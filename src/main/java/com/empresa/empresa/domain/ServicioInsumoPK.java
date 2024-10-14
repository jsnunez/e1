package com.empresa.empresa.domain;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Embeddable
public class ServicioInsumoPK implements Serializable {

    private Long id_servicio;
    private Long id_insumo;

    // No-argument constructor
    public ServicioInsumoPK() {}

    public ServicioInsumoPK(Long id_insumo, Long id_servicio) {
        this.id_insumo = id_insumo;
        this.id_servicio = id_servicio;
    }

    // Getters and setters...
}
