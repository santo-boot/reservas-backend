package com.curso.quarkus.application.service;

import com.curso.quarkus.domain.exception.BusinessException;
import com.curso.quarkus.domain.model.EstadoReserva;
import com.curso.quarkus.domain.model.Reserva;
import com.curso.quarkus.infraestructure.repository.ReservaRepository;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ReservaService {

    @Inject
    ReservaRepository reservaRepository;

    @Transactional
    public Reserva crearReserva(Reserva reserva) {

        validarReserva(reserva);

 //  VALIDACIÓN DE SOLAPAMIENTO
    boolean existeSolapamiento =
        !reservaRepository.buscarSolapadas(
            reserva.profesional.id,
            reserva.fecha,
            reserva.horaInicio,
            reserva.horaFin
        ).isEmpty();

    if (existeSolapamiento) {
        throw new BusinessException(
            "El profesional ya tiene una reserva activa en ese horario"
        );
    }


        reserva.estado = EstadoReserva.ACTIVA;
        reservaRepository.persist(reserva);
        return reserva;
    }

    public List<Reserva> listar() {
        return reservaRepository.listAll();
    }

    @Transactional
    public Reserva cancelar(Long id) {
    Reserva reserva = reservaRepository.findById(id);

    if (reserva == null) {
        throw new BusinessException("Reserva no encontrada");
    }

    reserva.estado = EstadoReserva.CANCELADA;
    return reserva;
}
   
    private void validarReserva(Reserva r) {

         if (r == null) {
            throw new BusinessException("La reserva no puede ser nula");
        }
        
        if (r.fecha == null) {
            throw new BusinessException("La fecha es obligatoria");
        }

        if (r.horaInicio == null || r.horaFin == null) {
            throw new BusinessException("La hora de inicio y fin son obligatorias");
        }

        if (r.horaFin.isBefore(r.horaInicio)) {
            throw new BusinessException("La hora fin debe ser mayor a la hora inicio");
        }

        if (r.cliente == null || r.profesional == null) {
            throw new BusinessException("Cliente y Profesional son obligatorios");
        }
    }
}
