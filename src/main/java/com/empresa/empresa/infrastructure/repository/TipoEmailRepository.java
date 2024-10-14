package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.TipoEmail;

public interface TipoEmailRepository extends JpaRepository<TipoEmail, Long> {

}