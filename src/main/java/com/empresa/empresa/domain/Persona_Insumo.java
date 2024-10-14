package com.empresa.empresa.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class Persona_Insumo {

    @EmbeddedId
   private PersonaInsumoPK id;
   @ManyToOne
   @JoinColumn(name="id_insumo",insertable=false, updatable = false)
   private Insumo insumo;
    
   @ManyToOne
   @JoinColumn(name="nro_documento",insertable=false, updatable = false)
   private Persona persona;

   @ManyToOne
   @JoinColumn(name="id_servicio",insertable=false, updatable = false)
   private Servicio servicio;



    // Getters y setters
}