package com.ezc.backend_empresas.infrastructure.controller;

import com.ezc.backend_empresas.infrastructure.persistence.entity.Empresa;
import com.ezc.backend_empresas.infrastructure.persistence.entity.Transferencia;


import com.ezc.backend_empresas.application.usecase.GetEmpresasConTransferenciasUseCase;
import com.ezc.backend_empresas.application.usecase.GetEmpresasAdheridasUltimoMesUseCase;

import com.ezc.backend_empresas.application.usecase.CreateEmpresaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ezc.backend_empresas.application.usecase.CreateTransferenciaUseCase;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    private final GetEmpresasConTransferenciasUseCase getEmpresasConTransferenciasUseCase;
    private final GetEmpresasAdheridasUltimoMesUseCase getEmpresasAdheridasUltimoMesUseCase;
    private final CreateEmpresaUseCase createEmpresaUseCase;
    private final CreateTransferenciaUseCase createTransferenciaUseCase;


    // Se inyectan casos de uso
    public EmpresaController(GetEmpresasConTransferenciasUseCase getEmpresasConTransferenciasUseCase,
                             GetEmpresasAdheridasUltimoMesUseCase getEmpresasAdheridasUltimoMesUseCase,
                             CreateEmpresaUseCase createEmpresaUseCase,
                             CreateTransferenciaUseCase createTransferenciaUseCase) {
        this.getEmpresasConTransferenciasUseCase = getEmpresasConTransferenciasUseCase;
        this.getEmpresasAdheridasUltimoMesUseCase = getEmpresasAdheridasUltimoMesUseCase;
        this.createEmpresaUseCase = createEmpresaUseCase;
        this.createTransferenciaUseCase = createTransferenciaUseCase;
    }

    @GetMapping("/con-transferencias")
    public List<Empresa> getEmpresasConTransferencias() {
        return getEmpresasConTransferenciasUseCase.execute();
    }

    @GetMapping("/adheridas-ultimo-mes")
    public List<Empresa> getEmpresasAdheridasUltimoMes() {
        return getEmpresasAdheridasUltimoMesUseCase.execute();
    }

    @PostMapping
    public ResponseEntity<Empresa> crearEmpresa(@RequestBody Empresa empresa) {
        Empresa creada = createEmpresaUseCase.execute(empresa);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @PostMapping("/transferencias")
    public ResponseEntity<Transferencia> crearTransferencia(@RequestBody Transferencia transferencia) {
        Transferencia creada = createTransferenciaUseCase.execute(transferencia);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }
}
