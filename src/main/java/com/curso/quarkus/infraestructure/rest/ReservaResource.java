package com.curso.quarkus.infraestructure.rest;

import java.util.List;

import com.curso.quarkus.application.service.ReservaService;
import com.curso.quarkus.domain.model.Reserva;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/reservas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservaResource {

    @Inject
    ReservaService service;

    @POST
    public Reserva crearReserva(@Valid Reserva reserva) {
        return service.crearReserva(reserva);
    }

    @PUT
    @Path("/{id}/cancelar")
    public Reserva cancelar(@Valid @PathParam("id") Long id) {
        return service.cancelar(id);
    }

    @GET
    public List<@Valid Reserva> listar() {
        return service.listar();
    }
}
