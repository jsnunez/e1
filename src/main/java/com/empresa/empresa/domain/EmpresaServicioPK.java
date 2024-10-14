package com.empresa.empresa.domain;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmpresaServicioPK implements Serializable{

    private Long idSucursal;
    private Long idServicio;
    public Long getIdSucursal() {
        return idSucursal;
    }
    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }
    public Long getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }
    public EmpresaServicioPK(Long idSucursal, Long idServicio) {
        this.idSucursal = idSucursal;
        this.idServicio = idServicio;
    }
    
}
