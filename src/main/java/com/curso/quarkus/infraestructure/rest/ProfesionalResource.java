package com.curso.quarkus.infraestructure.rest;

import com.curso.quarkus.application.service.ProfesionalService;
import com.curso.quarkus.domain.model.Profesional;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/profesionales")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfesionalResource {

    @Inject
    ProfesionalService service;

    @POST
    public Profesional crear(@Valid Profesional profesional) {
        return service.crear(profesional);
    }

    @GET
    public List<@Valid Profesional> listar() {
        return service.listar();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@Valid @PathParam("id") Long id, Profesional profesional) {
        Profesional actualizado = service.actualizar(id, profesional);
        return Response.ok(actualizado).build();
    }

}