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
public class Empresa_Servicio {

   @EmbeddedId
   private EmpresaServicioPK id;
   @ManyToOne
   @JoinColumn(name="idServicio",insertable=false, updatable = false)
   private Servicio servicio;
    
   @ManyToOne
   @JoinColumn(name="idSucursal",insertable=false, updatable = false)
   private Sucursal sucursal;
   
private double valorservicio;




    // Getters y setters
}