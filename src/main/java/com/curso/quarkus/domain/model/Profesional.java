package com.curso.quarkus.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Profesional extends PanacheEntity {

    @NotBlank
    public String nombres;

    @NotBlank
    public String apellidos;

    @NotBlank
    public String especialidad;

    public boolean estadoActivo;
}