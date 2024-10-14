package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.ITipoEmpresaService;
import com.empresa.empresa.domain.TipoEmpresa;
import com.empresa.empresa.infrastructure.repository.TipoEmpresaRepository;
@Service
public class TipoEmpresaAdapter implements ITipoEmpresaService {

    @Autowired
    private TipoEmpresaRepository tipoEmpresaRepository;

    @Override
    public Optional<TipoEmpresa> findById(Long id) {
        return tipoEmpresaRepository.findById(id);
    }

    @Override
    public List<TipoEmpresa> getAll() {
        return tipoEmpresaRepository.findAll();
    }

    @Override
    public TipoEmpresa save(TipoEmpresa tipoEmpresa) {
        return tipoEmpresaRepository.save(tipoEmpresa);
    }


    @Override
    public void deleteById(Long id) {
        tipoEmpresaRepository.deleteById(id);
    }

    @Override
    public TipoEmpresa update(Long id, TipoEmpresa tipoEmpresa) {
        return tipoEmpresaRepository.findById(id)
            .map(existingTipo -> {
                existingTipo.setDescripcion(tipoEmpresa.getDescripcion());
                return tipoEmpresaRepository.save(existingTipo);
            })
            .orElse(null);
        }
}
