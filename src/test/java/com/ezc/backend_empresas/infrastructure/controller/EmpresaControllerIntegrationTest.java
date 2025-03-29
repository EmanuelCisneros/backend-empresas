package com.ezc.backend_empresas.infrastructure.controller;

import com.ezc.backend_empresas.BackendEmpresasApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = BackendEmpresasApplication.class)
@AutoConfigureMockMvc
class EmpresaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void debeObtenerEmpresasConTransferencias() throws Exception {
        mockMvc.perform(get("/empresas/con-transferencias"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray());
    }
}
