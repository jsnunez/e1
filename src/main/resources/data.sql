INSERT INTO `estado_aprobacion` (`nombre`) VALUES
('Aprobado'),
('Rechazado'),
('Pendiente'),
('En revisión'),
('Cancelado');

-- Insertar registros en estado_orden
INSERT INTO `estado_orden` (`nombre`) VALUES
('Nuevo'),
('En Proceso'),
('Completado'),
('Cancelado'),
('Retrasado');

-- Insertar registros en pais
INSERT INTO `pais` (`nombre`) VALUES
('Colombia');

-- Insertar registros en region
INSERT INTO `region` (`id_pais`, `nombre`) VALUES
(1, 'Cundinamarca'),
(1, 'Antioquia'),
(1, 'Valle del Cauca');

-- Insertar registros en ciudad
INSERT INTO `ciudad` (`region_id`, `nombre`) VALUES
(1, 'Bogotá'),
(1, 'Soacha'),
(2, 'Medellín'),
(3, 'Cali');

-- Insertar registros en tipo_empresa
INSERT INTO `tipo_empresa` (`descripcion`) VALUES
('Taller Mecánico'),
('Servicio de Lavado'),
('Taller de Pintura'),
('Repuestos');

-- Insertar registros en empresa
INSERT INTO `empresa` (`tipo_empresa_id`, `nombre`) VALUES
(1, 'Taller Automotriz A'),
(1, 'Mecánica Rápida B'),
(2, 'Lavado Express C'),
(3, 'Pintura Profesional D'),
(1, 'Taller Total E');

-- Insertar registros en sucursal
INSERT INTO `sucursal` (`fecha_creacion`, `ciudad_id`, `empresa_id`, `nit`, `nombre_suc`) VALUES
('2023-01-01', 1, 1, '123456789-0', 'Sucursal Bogotá A'),
('2023-02-01', 2, 2, '987654321-0', 'Sucursal Medellín B'),
('2023-03-01', 3, 3, '456789123-0', 'Sucursal Cali C'),
('2023-04-01', 1, 4, '321654987-0', 'Sucursal Bogotá D'),
('2023-05-01', 1, 5, '789123456-0', 'Sucursal Soacha E');

-- Insertar registros en tipo_persona-- Insertar registros en tipo_persona
INSERT INTO tipo_persona (nombre) VALUES
('cliente'),
('empleado'),
('proveedor'),
('profesional');

-- Insertar registros en persona
INSERT INTO persona (fecha_registro, id_sucursal, nro_doc, tipo_persona_id, apellido, nombre) VALUES
('2023-01-01', 1, '1010101010', 1, 'Gómez', 'Juan'),
('2023-01-02', 1, '2020202020', 1, 'Pérez', 'María'),
('2023-01-03', 2, '3030303030', 1, 'López', 'Carlos'),
('2023-01-04', 3, '4040404040', 1, 'Martínez', 'Ana'),
('2023-01-05', 4, '5050505050', 2, 'Rodríguez', 'Luis'),
('2023-01-06', 5, '3324324234', 3, 'Importaciones', 'Gómez'),
('2023-01-06', 5, '3523424453', 4, 'martinez', 'camilo');


-- Insertar registros en tipo_telefono
INSERT INTO tipo_telefono (descripcion) VALUES
('Móvil'),
('Fijo'),
('Fax'),
('Trabajo'),
('Personal');

-- Insertar números de teléfono
INSERT INTO tel_persona (nro, nro_doc, id_tipo_tel) VALUES ('1010101010', '1010101010', 1); -- Móvil de Juan Gómez
INSERT INTO tel_persona (nro, nro_doc, id_tipo_tel) VALUES ('2020202020', '2020202020', 1); -- Móvil de María Pérez
INSERT INTO tel_persona (nro, nro_doc, id_tipo_tel) VALUES ('3030303030', '3030303030', 1); -- Móvil de Carlos López
INSERT INTO tel_persona (nro, nro_doc, id_tipo_tel) VALUES ('4040404040', '4040404040', 3); -- Fax de Ana Martínez
INSERT INTO tel_persona (nro, nro_doc, id_tipo_tel) VALUES ('5050505050', '5050505050', 2); -- Fijo de Luis Rodríguez
INSERT INTO tel_persona (nro, nro_doc, id_tipo_tel) VALUES ('3324324234', '3324324234', 4); -- Trabajo de Importaciones Gómez


-- Insertar registros en orden_servicio
INSERT INTO `orden_servicio` (`fecha_orden`, `id_cliente`, `id_empleado`, `id_estado`) VALUES
('2023-06-01', 1010101010, 5050505050, 1),
('2023-06-02', 2020202020, 5050505050, 2),
('2023-06-03', 3030303030, 5050505050, 3),
('2023-06-04', 3030303030, 3523424453, 4),
('2023-06-05', 3030303030, 3523424453, 5);

-- Insertar registros en servicio
INSERT INTO `servicio` (`requiere_insumo`, `nombre`) VALUES
(1, 'Cambio de aceite'),
(1, 'Revisión de frenos'),
(0, 'Lavado de carro'),
(1, 'Pintura de carro'),
(1, 'Reparación de motor');

-- Insertar registros en aprobacion_servicio
INSERT INTO `aprobacion_servicio` (`id_cliente`, `id_estado_aprobacion`, `id_servicio`, `no_orden`, `hallazgo`, `solucion`) VALUES
(1010101010, 1, 1, 1, 'Ninguno', 'Aprobado'),
(2020202020, 2, 2, 2, 'Revisar pastillas', 'Pendiente'),
(3030303030, 1, 3, 3, 'Ninguno', 'Aprobado'),
(3030303030, 3, 4, 4, 'Rayones', 'Aprobado'),
(3030303030, 2, 5, 5, 'Fugas de aceite', 'Pendiente');

-- Insertar registros en detalle_orden
INSERT INTO `detalle_orden` (`id_servicio`, `nombre`) VALUES
(1, 'Cambio de aceite sintético'),
(2, 'Revisión completa de frenos'),
(3, 'Lavado exterior e interior'),
(4, 'Pintura completa'),
(5, 'Reparación de motor a gasolina');

-- Insertar registros en orden_trabajo
INSERT INTO `orden_trabajo` (`fecha_asignacion`, `id_empleado`, `hora_asignacion`, `nro_ordent`) VALUES
('2023-06-01', 1, '09:00', 'OT-001'),
('2023-06-02', 2, '10:00', 'OT-002'),
('2023-06-03', 1, '11:00', 'OT-003'),
('2023-06-04', 3523424453, '12:00', 'OT-004'),
('2023-06-05', 3523424453, '13:00', 'OT-005');

-- Insertar registros en detalle_orden_trabajo
INSERT INTO `detalle_orden_trabajo` (`fecha`, `estado_orden_serv_id`, `orden_trabajo_id`, `servicio_asignado_id`) VALUES
('2023-06-01', 1, 1, 1),
('2023-06-02', 2, 2, 2),
('2023-06-03', 3, 3, 3),
('2023-06-04', 4, 4, 4),
('2023-06-05', 5, 5, 5);

-- Insertar registros en tipo_email
INSERT INTO `tipo_email` (`nombre`) VALUES
('Personal'),
('Laboral'),
('Promocional'),
('Notificaciones');

-- Insertar registros en email_per
INSERT INTO `email_per` (`id_tipo_email`, `nro_doc`, `email`) VALUES
(1, '1010101010', 'juan.gomez@example.com'),
(1, '2020202020', 'maria.perez@example.com'),
(1, '3030303030', 'carlos.lopez@example.com'),
(1, '4040404040', 'ana.martinez@example.com'),
(2, '5050505050', 'luis.rodriguez@example.com');

-- Insertar registros en empresa_servicio
INSERT INTO `empresa_servicio` (`valorservicio`, `id_servicio`, `id_sucursal`) VALUES
(150.0, 1, 1),
(200.0, 2, 1),
(100.0, 3, 2),
(300.0, 4, 2),
(250.0, 5, 3);

-- Insertar registros en estado_ser_orden
INSERT INTO `estado_ser_orden` (`nombre`) VALUES
('Pendiente'),
('En Proceso'),
('Finalizado'),
('Cancelado'),
('Rechazado');

-- Insertar registros en insumo
INSERT INTO `insumo` (`stock`, `stock_max`, `stock_min`, `valor_unit`, `cod_interno`, `nombre_insumo`) VALUES
(50, 200, 20, 30.0, 'INS-001', 'Aceite sintético'),
(100, 500, 50, 25.0, 'INS-002', 'Pastillas de freno'),
(75, 300, 30, 20.0, 'INS-003', 'Jabón para lavado'),
(60, 250, 25, 40.0, 'INS-004', 'Pintura automotriz'),
(30, 100, 10, 150.0, 'INS-005', 'Repuestos de motor');


-- Insertar registros en persona_insumo
INSERT INTO `persona_insumo` (`id_insumo`, `id_servicio`, `nro_documento`) VALUES
(1, 1, '1010101010'),
(2, 2, '2020202020'),
(3, 3, '3030303030'),
(4, 4, '4040404040'),
(5, 5, '5050505050');