package com.empresa.empresa.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class Persona {

    @Id
    private Long nroDoc;

    private String nombre;
    private String apellido;
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "tipo_persona_id")
    private TipoPersona tipoPersona;

    // Getters y setters
}