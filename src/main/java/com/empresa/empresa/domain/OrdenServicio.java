package com.empresa.empresa.domain;

import java.time.LocalDate;

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
public class OrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noOrden;

    private LocalDate fechaOrden;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Persona cliente;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Persona empleado;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoOrden estado;

    // Getters y setters
}