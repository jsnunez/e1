package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.ServicioInsumo;
import com.empresa.empresa.domain.ServicioInsumoPK;

public interface ServicioInsumoRepository extends JpaRepository<ServicioInsumo, ServicioInsumoPK> {


}
