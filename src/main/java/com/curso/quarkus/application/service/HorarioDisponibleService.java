package com.curso.quarkus.application.service;

import com.curso.quarkus.domain.model.HorarioDisponible;
import com.curso.quarkus.domain.model.Profesional;
import com.curso.quarkus.infraestructure.repository.HorarioDisponibleRepository;
import com.curso.quarkus.infraestructure.repository.ProfesionalRepository;
import com.curso.quarkus.domain.exception.BusinessException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@ApplicationScoped
public class HorarioDisponibleService {

    @Inject
    HorarioDisponibleRepository horarioRepository;

    @Inject
    ProfesionalRepository profesionalRepository;

    @Transactional
    public HorarioDisponible crearHorario(Long profesionalId,
            LocalDate fecha,
            LocalTime horaInicio,
            LocalTime horaFin) {

        Profesional profesional = profesionalRepository.findById(profesionalId);

        if (profesional == null) {
            throw new BusinessException("Profesional no encontrado");
        }

        if (!profesional.estadoActivo) {
            throw new BusinessException("El profesional no está activo");
        }

        if (horaInicio.isAfter(horaFin) || horaInicio.equals(horaFin)) {
            throw new BusinessException("La hora de inicio debe ser menor a la hora fin");
        }

        HorarioDisponible horario = new HorarioDisponible();
        horario.profesional = profesional;
        horario.fecha = fecha;
        horario.horaInicio = horaInicio;
        horario.horaFin = horaFin;
        horario.estado = true;

        horarioRepository.persist(horario);
        return horario;
    }

    public List<HorarioDisponible> listarPorProfesional(Long profesionalId) {
        return horarioRepository.find(
                "profesional.id = ?1 and estado = true",
                profesionalId).list();
    }

     @Transactional
    public void marcarNoDisponible(Long horarioId) {
        HorarioDisponible horario = horarioRepository.findById(horarioId);

        if (horario == null) {
            throw new BusinessException("El horario no existe");
        }

        if (!horario.estado) {
            throw new BusinessException("El horario ya no está disponible");
        }

        horario.estado = false;
    }

}
