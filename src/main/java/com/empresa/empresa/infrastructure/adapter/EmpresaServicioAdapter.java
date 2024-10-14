package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IEmpresaServicioService;
import com.empresa.empresa.domain.EmpresaServicioPK;
import com.empresa.empresa.domain.Empresa_Servicio;
import com.empresa.empresa.infrastructure.repository.Empresa_ServicioRepository;



@Service
public class EmpresaServicioAdapter implements IEmpresaServicioService {

    @Autowired
    private Empresa_ServicioRepository empresaServicioRepository;

    @Override
    public Optional<Empresa_Servicio> findById(EmpresaServicioPK id) {
        return empresaServicioRepository.findById(id);
    }

    @Override
    public List<Empresa_Servicio> getAll() {
        return empresaServicioRepository.findAll();
    }

    @Override
    public Empresa_Servicio save(Empresa_Servicio empresaServicio) {
        return empresaServicioRepository.save(empresaServicio);
    }

    @Override
    public Empresa_Servicio update(EmpresaServicioPK id, Empresa_Servicio empresaServicio) {
        return empresaServicioRepository.findById(id)
            .map(existingEmpresaServicio -> {
                existingEmpresaServicio.setValorservicio(empresaServicio.getValorservicio());
                return empresaServicioRepository.save(existingEmpresaServicio);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(EmpresaServicioPK id) {
        empresaServicioRepository.deleteById(id);
    }
}
