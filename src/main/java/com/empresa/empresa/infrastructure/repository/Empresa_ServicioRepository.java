package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.EmpresaServicioPK;
import com.empresa.empresa.domain.Empresa_Servicio;


public interface Empresa_ServicioRepository extends JpaRepository<Empresa_Servicio, EmpresaServicioPK> {

}
