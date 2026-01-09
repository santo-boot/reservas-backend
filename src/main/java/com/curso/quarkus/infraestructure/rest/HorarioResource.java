package com.curso.quarkus.infraestructure.rest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.curso.quarkus.application.service.HorarioDisponibleService;
import com.curso.quarkus.domain.model.HorarioDisponible;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;

@Path("/horarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HorarioResource {

    @Inject
    HorarioDisponibleService service;

    @POST
    public HorarioDisponible crear(@Valid Map<String, String> request) {
        Long profesionalId = Long.valueOf(request.get("profesionalId"));
        LocalDate fecha = LocalDate.parse(request.get("fecha"));
        LocalTime horaInicio = LocalTime.parse(request.get("horaInicio"));
        LocalTime horaFin = LocalTime.parse(request.get("horaFin"));

        return service.crearHorario(
                profesionalId,
                fecha,
                horaInicio,
                horaFin
        );
    }

    @GET
    @Path("/profesional/{id}")
    public List<@Valid HorarioDisponible> listarPorProfesional(
            @PathParam("id") Long profesionalId) {

        return service.listarPorProfesional(profesionalId);
    }

}