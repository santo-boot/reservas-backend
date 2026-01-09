package com.curso.quarkus.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class HorarioDisponible extends PanacheEntity {


    @ManyToOne
    public Profesional profesional;

    public LocalDate fecha;
    public LocalTime horaInicio;
    public LocalTime horaFin;

    public boolean estado;
}