package com.curso.quarkus.infraestructure.repository;
import com.curso.quarkus.domain.model.Profesional;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProfesionalRepository implements PanacheRepository<Profesional> {
}
