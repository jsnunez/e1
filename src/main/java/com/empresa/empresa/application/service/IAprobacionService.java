package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.AprobacionServicio;

public interface IAprobacionService {
    Optional<AprobacionServicio> findById(Long id);
    List<AprobacionServicio> getAll();
    AprobacionServicio save(AprobacionServicio aprobacionServicio);
    AprobacionServicio update(Long id, AprobacionServicio aprobacionServicio);
    void deleteById(Long id);
}

