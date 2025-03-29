package com.ezc.backend_empresas.application.usecase;

import com.ezc.backend_empresas.infrastructure.persistence.entity.Empresa;
import com.ezc.backend_empresas.infrastructure.persistence.repository.EmpresaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateEmpresaUseCaseTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @InjectMocks
    private CreateEmpresaUseCase useCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void debeCrearUnaEmpresa() {
        // Arrange
        Empresa empresa = Empresa.builder()
                .id("empresaTest")
                .nombre("Empresa Test")
                .cuit("30-11111111-1")
                .fechaAlta(new Date())
                .build();

        when(empresaRepository.save(empresa)).thenReturn(empresa);

        Empresa creada = useCase.execute(empresa);

        assertNotNull(creada);
        assertEquals("Empresa Test", creada.getNombre());
        verify(empresaRepository, times(1)).save(empresa);
    }
}