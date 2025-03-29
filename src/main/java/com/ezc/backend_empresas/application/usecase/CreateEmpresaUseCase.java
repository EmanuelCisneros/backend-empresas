package com.ezc.backend_empresas.application.usecase;

import com.ezc.backend_empresas.infrastructure.persistence.entity.Empresa;
import com.ezc.backend_empresas.infrastructure.persistence.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateEmpresaUseCase {

    private final EmpresaRepository empresaRepository;

    public CreateEmpresaUseCase(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa execute(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}
