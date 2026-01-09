package com.curso.quarkus.infraestructure.repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.curso.quarkus.domain.model.EstadoReserva;
import com.curso.quarkus.domain.model.Reserva;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReservaRepository implements PanacheRepository<Reserva> {

    public List<Reserva> buscarSolapadas(
            Long profesionalId,
            LocalDate fecha,
            LocalTime horaInicio,
            LocalTime horaFin
    ) {
        return find(
            "profesional.id = ?1 " +
            "and fecha = ?2 " +
            "and estado = ?3 " +
            "and horaInicio < ?4 " +
            "and horaFin > ?5",
            profesionalId,
            fecha,
            EstadoReserva.ACTIVA,
            horaFin,
            horaInicio
        ).list();
    }

}
