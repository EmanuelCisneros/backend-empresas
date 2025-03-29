package com.ezc.backend_empresas.infrastructure.persistence.repository;

import com.ezc.backend_empresas.infrastructure.persistence.entity.Empresa;
import com.ezc.backend_empresas.infrastructure.persistence.entity.Transferencia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransferenciaRepository extends MongoRepository<Transferencia, String> {
    List<Transferencia> findByFechaGreaterThanEqual(Date fecha);
}