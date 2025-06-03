package com.pablix.tiempos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pablix.tiempos.models.Runner;

@Repository
public interface RunnerRepository extends JpaRepository<Runner, Long> {
    Optional<Runner> findByDpi(String dpi);
    boolean existsByDpi(String dpi);
}