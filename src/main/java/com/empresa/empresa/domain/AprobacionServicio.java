package com.empresa.empresa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class AprobacionServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "no_orden")
    private OrdenServicio ordenServicio;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Persona cliente;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    private String hallazgo;
    private String solucion;

    @ManyToOne
    @JoinColumn(name = "id_estado_aprobacion")
    private EstadoAprobacion estadoAprobacion;

    // Getters y setters
}