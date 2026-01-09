INSERT INTO profesional (id, nombres, apellidos, especialidad, estadoactivo) VALUES
(1, 'Luis', 'Salazar', 'Psicología', true),
(2, 'María', 'Paredes', 'Fisioterapia', true),
(3, 'Carlos', 'Mendoza', 'Traumatología', true),
(4, 'Ana', 'Villacís', 'Nutrición', true),
(5, 'Francisco', 'Montalván', 'Asesorías', true);


INSERT INTO cliente (id, nombres, apellidos, email, telefono, estadoactivo) VALUES
(1, 'Andrea', 'Parra', 'andrea.parra@mail.com', '0991111111', true),
(2, 'Johana', 'Guachichulca', 'johana.guachi@mail.com', '0992222222', true),
(3, 'Cristina', 'Díaz', 'cristina.diaz@mail.com', '0993333333', true),
(4, 'Miguel', 'Torres', 'miguel.torres@mail.com', '0994444444', true),
(5, 'Paola', 'Vera', 'paola.vera@mail.com', '0995555555', true),
(6, 'Daniel', 'Cruz', 'daniel.cruz@mail.com', '0996666666', true),
(7, 'Lucía', 'Romero', 'lucia.romero@mail.com', '0997777777', true),
(8, 'José', 'Navarro', 'jose.navarro@mail.com', '0998888888', true),
(9, 'Valeria', 'Molina', 'valeria.molina@mail.com', '0999999999', true),
(10, 'Pedro', 'Herrera', 'pedro.herrera@mail.com', '0980000000', true);


INSERT INTO horariodisponible (id, fecha, horainicio, horafin, profesional_id, estado) VALUES
(1, '2026-01-10', '08:00', '09:00', 1, true),
(2, '2026-01-10', '09:00', '10:00', 1, true),
(3, '2026-01-11', '10:00', '11:00', 1, true),
(4, '2026-01-12', '14:00', '15:00', 1, true),
(5, '2026-01-13', '15:00', '16:00', 1, true);

INSERT INTO horariodisponible (id, fecha, horainicio, horafin, profesional_id, estado) VALUES
(6, '2026-01-10', '08:00', '09:00', 2, true),
(7, '2026-01-10', '09:00', '10:00', 2, true),
(8, '2026-01-11', '11:00', '12:00', 2, true),
(9, '2026-01-12', '14:00', '15:00', 2, true),
(10, '2026-01-13', '16:00', '17:00', 2, true);

INSERT INTO horariodisponible (id, fecha, horainicio, horafin, profesional_id, estado) VALUES
(11, '2026-01-10', '10:00', '11:00', 3, true),
(12, '2026-01-10', '11:00', '12:00', 3, true),
(13, '2026-01-11', '08:00', '09:00', 3, true),
(14, '2026-01-12', '09:00', '10:00', 3, true),
(15, '2026-01-13', '14:00', '15:00', 3, true);

INSERT INTO horariodisponible (id, fecha, horainicio, horafin, profesional_id, estado) VALUES
(16, '2026-01-10', '08:00', '09:00', 4, true),
(17, '2026-01-11', '09:00', '10:00', 4, true),
(18, '2026-01-12', '10:00', '11:00', 4, true),
(19, '2026-01-13', '14:00', '15:00', 4, true),
(20, '2026-01-14', '15:00', '16:00', 4, true);

INSERT INTO horariodisponible (id, fecha, horainicio, horafin, profesional_id, estado) VALUES
(21, '2026-01-10', '09:00', '10:00', 5, true),
(22, '2026-01-10', '10:00', '11:00', 5, true),
(23, '2026-01-11', '11:00', '12:00', 5, true),
(24, '2026-01-12', '14:00', '15:00', 5, true),
(25, '2026-01-13', '16:00', '17:00', 5, true);