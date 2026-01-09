package com.curso.quarkus.domain.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservas")
public class Reserva extends PanacheEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public LocalDate fecha;
    public LocalTime horaInicio;
    public LocalTime horaFin;

    @ManyToOne
    public Cliente cliente;

    @ManyToOne
    public Profesional profesional;

    @Enumerated(EnumType.STRING)
    public EstadoReserva estado;



    
}

