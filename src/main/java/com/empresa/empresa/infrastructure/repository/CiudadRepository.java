package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

}
