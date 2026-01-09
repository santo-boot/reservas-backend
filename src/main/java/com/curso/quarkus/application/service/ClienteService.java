package com.curso.quarkus.application.service;

import com.curso.quarkus.domain.model.Cliente;
import com.curso.quarkus.infraestructure.repository.ClienteRepository;
import com.curso.quarkus.domain.exception.BusinessException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository repository;

    @Transactional
    public Cliente crear(Cliente cliente) {

        if (cliente.nombres == null || cliente.nombres.trim().isEmpty()) {
            throw new BusinessException("El nombre del cliente es obligatorio");
        }

        repository.persist(cliente);
        return cliente;
    }

    public List<Cliente> listar() {
        return Cliente.listAll();
    }

    @Transactional
    public Cliente actualizar(Long id, Cliente datos) {

        Cliente cliente = Cliente.findById(id);

        if (cliente == null) {
            throw new BusinessException("Cliente no encontrado");
        }

        cliente.nombres = datos.nombres;
        cliente.apellidos = datos.apellidos;
        cliente.email = datos.email;
        cliente.telefono = datos.telefono;
        cliente.estadoActivo = datos.estadoActivo;

        return cliente;
    }

}
