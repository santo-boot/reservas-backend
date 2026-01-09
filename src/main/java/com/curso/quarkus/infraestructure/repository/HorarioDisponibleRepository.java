package com.curso.quarkus.infraestructure.repository;
import com.curso.quarkus.domain.model.HorarioDisponible;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HorarioDisponibleRepository implements PanacheRepository<HorarioDisponible> {
}
