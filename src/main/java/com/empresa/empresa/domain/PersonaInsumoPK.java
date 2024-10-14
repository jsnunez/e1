package com.empresa.empresa.domain;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PersonaInsumoPK implements Serializable {

    private Long id_insumo;
    private Long nro_documento;
    private long id_servicio;



    
    public Long getId_insumo() {
        return id_insumo;
    }
    public void setId_insumo(Long id_insumo) {
        this.id_insumo = id_insumo;
    }
    public Long getNro_documento() {
        return nro_documento;
    }
    public void setNro_documento(Long nro_documento) {
        this.nro_documento = nro_documento;
    }
    public long getId_servicio() {
        return id_servicio;
    }
    public void setId_servicio(long id_servicio) {
        this.id_servicio = id_servicio;
    }
    public PersonaInsumoPK(Long id_insumo, Long nro_documento, long id_servicio) {
        this.id_insumo = id_insumo;
        this.nro_documento = nro_documento;
        this.id_servicio = id_servicio;
    }
    
}
