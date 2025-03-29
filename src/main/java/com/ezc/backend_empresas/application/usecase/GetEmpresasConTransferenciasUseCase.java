package com.ezc.backend_empresas.application.usecase;

import com.ezc.backend_empresas.infrastructure.persistence.repository.TransferenciaRepository;
import com.ezc.backend_empresas.infrastructure.persistence.repository.EmpresaRepository;
import com.ezc.backend_empresas.infrastructure.persistence.entity.Empresa;
import com.ezc.backend_empresas.infrastructure.persistence.entity.Transferencia;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GetEmpresasConTransferenciasUseCase {

    private final EmpresaRepository empresaRepository;
    private final TransferenciaRepository transferenciaRepository;

    public GetEmpresasConTransferenciasUseCase(EmpresaRepository empresaRepository,
                                               TransferenciaRepository transferenciaRepository) {
        this.empresaRepository = empresaRepository;
        this.transferenciaRepository = transferenciaRepository;
    }

    public List<Empresa> execute() {
        //Para obtener la fecha un mes atrás desde hoy
        Date fechaUnMesAtras = Date.from(
                LocalDate.now().minusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant()
        );

        // Consulta transferencias desde esa fecha
        List<Transferencia> transferencias = transferenciaRepository.findByFechaGreaterThanEqual(fechaUnMesAtras);

        // Extrae los IDs únicos de empresas desde las transferencias
        Set<String> empresaIds = transferencias.stream()
                .map(Transferencia::getEmpresaId)
                .collect(Collectors.toSet());

        //  Devuelve las empresas cuyo ID esté en esa lista
        return empresaRepository.findByIdIn(empresaIds);
    }
}



