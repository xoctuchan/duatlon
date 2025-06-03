package com.pablix.tiempos.models;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "corredor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Runner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dpi;

    private String nombre;

    private String apellido;

    private LocalDate fechaNacimiento;

    private String genero;

    private String email;

    private String telefono;

    @Column(name = "fecha_registro", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime fechaRegistro = ZonedDateTime.now();
}