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
public class TelPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nro;
    
    @ManyToOne
    @JoinColumn(name = "nro_doc")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_tipo_tel")
    private TipoTelefono tipoTelefono;

    // Getters y setters
}