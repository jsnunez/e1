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
public class ServicioInsumo {

    @EmbeddedId
    private ServicioInsumoPK id;

    @ManyToOne
    @JoinColumn(name = "id_servicio", insertable = false, updatable = false)
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "id_insumo", insertable = false, updatable = false)
    private Insumo insumo;

    private int cantidadUsado;

    // Constructor por defecto
    public ServicioInsumo() {}

    // Constructor con parámetros
    public ServicioInsumo(int cantidadUsado, ServicioInsumoPK id, Insumo insumo, Servicio servicio) {
        this.cantidadUsado = cantidadUsado;
        this.id = id;
        this.insumo = insumo;
        this.servicio = servicio;
    }
}