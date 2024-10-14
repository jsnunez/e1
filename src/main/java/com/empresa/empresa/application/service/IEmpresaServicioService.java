package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.EmpresaServicioPK;
import com.empresa.empresa.domain.Empresa_Servicio;

public interface IEmpresaServicioService {
    Optional<Empresa_Servicio> findById(EmpresaServicioPK id);
    List<Empresa_Servicio> getAll();
    Empresa_Servicio save(Empresa_Servicio empresaServicio);
    Empresa_Servicio update(EmpresaServicioPK id, Empresa_Servicio empresaServicio);
    void deleteById(EmpresaServicioPK id);
}

