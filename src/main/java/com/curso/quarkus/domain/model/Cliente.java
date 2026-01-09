package com.curso.quarkus.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Cliente extends PanacheEntity {


    @NotBlank
    public String nombres;

    @NotBlank
    public String apellidos;

    @Email
    @NotBlank
    public String email;

    public String telefono;

    public boolean estadoActivo;
}

