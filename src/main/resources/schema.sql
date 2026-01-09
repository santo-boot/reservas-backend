CREATE TABLE profesional (
    id BIGSERIAL PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    estadoActivo BOOLEAN NOT NULL
);

CREATE TABLE cliente (
    id BIGSERIAL PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefono VARCHAR(20),
    estadoActivo BOOLEAN NOT NULL
);

CREATE TABLE horario_disponible (
    id BIGSERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    horaInicio TIME NOT NULL,
    horaFin TIME NOT NULL,
    profesional_id BIGINT NOT NULL,
    CONSTRAINT fk_horario_profesional
        FOREIGN KEY (profesional_id) REFERENCES profesional(id)
);

CREATE TABLE reserva (
    id BIGSERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    horaInicio TIME NOT NULL,
    horaFin TIME NOT NULL,
    estado VARCHAR(20) NOT NULL,
    cliente_id BIGINT NOT NULL,
    profesional_id BIGINT NOT NULL,
    CONSTRAINT fk_reserva_cliente
        FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    CONSTRAINT fk_reserva_profesional
        FOREIGN KEY (profesional_id) REFERENCES profesional(id)
);
