package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IEmpresaService;
import com.empresa.empresa.domain.Empresa;
import com.empresa.empresa.infrastructure.repository.EmpresaRepository;



@Service
public class EmpresaAdapter implements IEmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Optional<Empresa> findById(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa update(Long id, Empresa empresa) {
        return empresaRepository.findById(id)
            .map(existingEmpresa -> {
                existingEmpresa.setNombre(empresa.getNombre());
                return empresaRepository.save(existingEmpresa);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        empresaRepository.deleteById(id);
    }
}



