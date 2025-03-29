package com.ezc.backend_empresas.infrastructure.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "empresas")

public class Empresa {

    @Id
    private String id;

    private String nombre;

    private String cuit;

    private Date fechaAlta; // ✅ Campo agregado
}

