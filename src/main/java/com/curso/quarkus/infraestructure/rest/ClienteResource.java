package com.curso.quarkus.infraestructure.rest;
import java.util.List;
import com.curso.quarkus.application.service.ClienteService;
import com.curso.quarkus.domain.model.Cliente;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteService service;

    @POST
    public Cliente crear(@Valid Cliente cliente) {
        return service.crear(cliente);
    }

    @GET
    public List<@Valid Cliente> listar() {
        return service.listar();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@Valid@PathParam("id") Long id, Cliente cliente) {
        Cliente actualizado = service.actualizar(id, cliente);
        return Response.ok(actualizado).build();
    }

}