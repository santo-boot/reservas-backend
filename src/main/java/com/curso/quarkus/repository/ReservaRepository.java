package com.curso.quarkus.repository;
import com.curso.quarkus.domain.model.Reserva;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class ReservaRepository implements PanacheRepository<Reserva> {

    public List<Reserva> listarActivas() {
        return list("cancelada = false");
    }

    public List<Reserva> buscarPorFecha(LocalDate fecha) {
        return list("fecha", fecha);
    }
}
