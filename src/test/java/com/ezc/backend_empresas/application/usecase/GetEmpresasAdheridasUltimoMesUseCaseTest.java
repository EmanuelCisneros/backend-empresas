package com.ezc.backend_empresas.application.usecase;

import com.ezc.backend_empresas.infrastructure.persistence.entity.Empresa;
import com.ezc.backend_empresas.infrastructure.persistence.repository.EmpresaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetEmpresasAdheridasUltimoMesUseCaseTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @InjectMocks
    private GetEmpresasAdheridasUltimoMesUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void debeRetornarEmpresasAdheridasUltimoMes() {
        // Arrange
        Empresa empresa = Empresa.builder()
                .id("empresa001")
                .nombre("Empresa Nueva")
                .cuit("30-12345678-9")
                .fechaAlta(new Date())
                .build();

        when(empresaRepository.findByFechaAltaGreaterThanEqual(any(Date.class)))
                .thenReturn(List.of(empresa));

        // Act
        List<Empresa> resultado = useCase.execute();

        // Assert
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Empresa Nueva", resultado.get(0).getNombre());

        verify(empresaRepository, times(1)).findByFechaAltaGreaterThanEqual(any(Date.class));
    }
}