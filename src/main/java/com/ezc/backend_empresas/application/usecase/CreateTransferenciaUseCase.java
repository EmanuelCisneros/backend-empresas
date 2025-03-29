package com.ezc.backend_empresas.application.usecase;

import com.ezc.backend_empresas.infrastructure.persistence.entity.Transferencia;
import com.ezc.backend_empresas.infrastructure.persistence.repository.TransferenciaRepository;

import org.springframework.stereotype.Service;

@Service
public class CreateTransferenciaUseCase {

    private final TransferenciaRepository transferenciaRepository;

    public CreateTransferenciaUseCase(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    public Transferencia execute(Transferencia transferencia) {
        return transferenciaRepository.save(transferencia);
    }
}