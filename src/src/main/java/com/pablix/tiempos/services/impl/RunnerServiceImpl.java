package com.pablix.tiempos.services.impl;

import com.pablix.tiempos.models.Runner;
import com.pablix.tiempos.repositories.RunnerRepository;
import com.pablix.tiempos.services.RunnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RunnerServiceImpl implements RunnerService {

    private final RunnerRepository runnerRepository;

    @Override
    public Runner guardar(Runner runner) {
        return runnerRepository.save(runner);
    }

    @Override
    public Optional<Runner> obtenerPorId(Long id) {
        return runnerRepository.findById(id);
    }

    @Override
    public Optional<Runner> obtenerPorDpi(String dpi) {
        return runnerRepository.findByDpi(dpi);
    }

    @Override
    public List<Runner> listarTodos() {
        return runnerRepository.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {
        runnerRepository.deleteById(id);
    }
}
