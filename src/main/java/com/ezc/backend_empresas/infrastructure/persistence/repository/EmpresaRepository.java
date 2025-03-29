package com.ezc.backend_empresas.infrastructure.persistence.repository;

import com.ezc.backend_empresas.infrastructure.persistence.entity.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface EmpresaRepository extends MongoRepository<Empresa, String> {

    List<Empresa> findByIdIn(Set<String> ids);

    List<Empresa> findByFechaAltaGreaterThanEqual(Date fecha);
}
