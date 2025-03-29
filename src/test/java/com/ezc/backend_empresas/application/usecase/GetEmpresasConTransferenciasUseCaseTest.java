package com.ezc.backend_empresas.application.usecase;

import com.ezc.backend_empresas.infrastructure.persistence.entity.Empresa;
import com.ezc.backend_empresas.infrastructure.persistence.entity.Transferencia;
import com.ezc.backend_empresas.infrastructure.persistence.repository.EmpresaRepository;
import com.ezc.backend_empresas.infrastructure.persistence.repository.TransferenciaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetEmpresasConTransferenciasUseCaseTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @Mock
    private TransferenciaRepository transferenciaRepository;

    @InjectMocks
    private GetEmpresasConTransferenciasUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void debeRetornarEmpresasConTransferenciasDelUltimoMes() {
        // Arrange
        String empresaId = "empresa123";

        Transferencia transferencia = Transferencia.builder()
                .id("1")
                .empresaId(empresaId)
                .importe(new BigDecimal("1500.00"))
                .fecha(new Date())
                .cuentaCredito("987654")
                .cuentaDebito("123456")
                .build();

        Empresa empresa = Empresa.builder()
                .id(empresaId)
                .nombre("Empresa Ejemplo")
                .cuit("30-12345678-9")
                .fechaAlta(new Date())
                .build();

        List<Transferencia> transferencias = List.of(transferencia);
        Set<String> empresaIds = Set.of(empresaId);
        List<Empresa> empresas = List.of(empresa);

        when(transferenciaRepository.findByFechaGreaterThanEqual(any(Date.class))).thenReturn(transferencias);
        when(empresaRepository.findByIdIn(empresaIds)).thenReturn(empresas);

        // Act
        List<Empresa> resultado = useCase.execute();

        // Assert
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Empresa Ejemplo", resultado.get(0).getNombre());

        verify(transferenciaRepository, times(1)).findByFechaGreaterThanEqual(any(Date.class));
        verify(empresaRepository, times(1)).findByIdIn(empresaIds);
    }
}