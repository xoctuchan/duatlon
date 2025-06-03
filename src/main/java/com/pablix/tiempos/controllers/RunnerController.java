package com.pablix.tiempos.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablix.tiempos.models.Runner;
import com.pablix.tiempos.response.ApiResponse;
import com.pablix.tiempos.response.ApiResponseBuilder;
import com.pablix.tiempos.services.RunnerService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/runners")
@RequiredArgsConstructor
public class RunnerController {

    private final RunnerService runnerService;

    @PostMapping
    public ResponseEntity<ApiResponse<Runner>> crearRunner(@RequestBody Runner runner) {
        if (runnerService.obtenerPorDpi(runner.getDpi()).isPresent()) {
            return ApiResponseBuilder.badRequest("El DPI '" + runner.getDpi() + "' ya existe en el sistema.");
        }
        Runner guardado = runnerService.guardar(runner);
        return ApiResponseBuilder.created("Runner creado correctamente", guardado);
    }

    @GetMapping
    public ResponseEntity<List<Runner>> listarRunners() {
        return ResponseEntity.ok(runnerService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Runner> obtenerRunnerPorId(@PathVariable Long id) {
        return runnerService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dpi/{dpi}")
    public ResponseEntity<Runner> obtenerRunnerPorDpi(@PathVariable String dpi) {
        return runnerService.obtenerPorDpi(dpi)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Runner> actualizarRunner(@PathVariable Long id, @RequestBody Runner runner) {
        return runnerService.obtenerPorId(id).map(existing -> {
            runner.setId(id);
            Runner actualizado = runnerService.guardar(runner);
            return ResponseEntity.ok(actualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarRunner(@PathVariable Long id) {
        return runnerService.obtenerPorId(id).map(existing -> {
            runnerService.eliminarPorId(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}