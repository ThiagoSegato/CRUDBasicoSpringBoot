package com.gcc.crudbasico.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.crudbasico.api.model.Integrante;

public interface IntegranteRepository extends JpaRepository<Integrante, Long> {

}
