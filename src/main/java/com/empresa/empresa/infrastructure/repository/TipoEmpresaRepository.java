package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.TipoEmpresa;

public interface TipoEmpresaRepository extends JpaRepository<TipoEmpresa, Long> {

}
