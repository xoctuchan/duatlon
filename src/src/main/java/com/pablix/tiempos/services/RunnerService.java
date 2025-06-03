package com.pablix.tiempos.services;

import java.util.List;
import java.util.Optional;

import com.pablix.tiempos.models.Runner;

public interface RunnerService{
    Runner guardar(Runner runner);
    Optional<Runner> obtenerPorId(Long id);
    Optional<Runner> obtenerPorDpi(String dpi);
    List<Runner> listarTodos();
    void eliminarPorId(Long id);
}