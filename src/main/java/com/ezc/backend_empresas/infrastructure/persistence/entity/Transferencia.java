package com.ezc.backend_empresas.infrastructure.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "transferencias")
public class Transferencia {

    @Id
    private String id;
    private BigDecimal importe;
    private String empresaId;
    private String cuentaDebito;
    private String cuentaCredito;
    private Date fecha;
}