package com.curso.quarkus.application.service;

import com.curso.quarkus.domain.model.Profesional;
import com.curso.quarkus.infraestructure.repository.ProfesionalRepository;
import com.curso.quarkus.domain.exception.BusinessException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProfesionalService {

    @Inject
    ProfesionalRepository repository;

    @Transactional
    public Profesional crear(Profesional profesional) {

        if (profesional.nombres == null || profesional.nombres.trim().isEmpty()) {
            throw new BusinessException("El nombre del profesional es obligatorio");
        }

        repository.persist(profesional);
        return profesional;
    }

    public List<Profesional> listar() {
        return Profesional.listAll();
    }

    @Transactional
    public Profesional actualizar(Long id, Profesional datos) {

        Profesional profesional = Profesional.findById(id);

        if (profesional == null) {
            throw new BusinessException("Profesional no encontrado");
        }

        profesional.nombres = datos.nombres;
        profesional.apellidos = datos.apellidos;
        profesional.especialidad = datos.especialidad;
        profesional.estadoActivo = datos.estadoActivo;

        return profesional;
    }

}
