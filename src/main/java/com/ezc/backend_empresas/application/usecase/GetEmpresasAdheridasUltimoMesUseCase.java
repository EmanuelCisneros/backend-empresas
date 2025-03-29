package com.ezc.backend_empresas.application.usecase;

import com.ezc.backend_empresas.infrastructure.persistence.entity.Empresa;
import com.ezc.backend_empresas.infrastructure.persistence.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class GetEmpresasAdheridasUltimoMesUseCase {

    private final EmpresaRepository empresaRepository;

    public GetEmpresasAdheridasUltimoMesUseCase(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> execute() {
        Date fechaUnMesAtras = Date.from(LocalDate.now().minusMonths(1)
                .atStartOfDay(ZoneId.systemDefault()).toInstant());

        return empresaRepository.findByFechaAltaGreaterThanEqual(fechaUnMesAtras);
    }
}
