package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.ISucursalService;
import com.empresa.empresa.domain.Sucursal;
import com.empresa.empresa.infrastructure.repository.SucursalRepository;
@Service
public class SucursalAdapter implements ISucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public Optional<Sucursal> findById(Long id) {
        return sucursalRepository.findById(id);
    }

    @Override
    public List<Sucursal> getAll() {
        return sucursalRepository.findAll();
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal update(Long id, Sucursal sucursal) {
        return sucursalRepository.findById(id)
            .map(existingSucursal -> {
                existingSucursal.setEmpresa(sucursal.getEmpresa());
                return sucursalRepository.save(existingSucursal);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        sucursalRepository.deleteById(id);
    }
}
