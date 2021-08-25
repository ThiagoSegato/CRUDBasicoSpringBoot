package com.gcc.crudbasico.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.gcc.crudbasico.api.model.Banda;

@Repository
public interface BandaRepository extends JpaRepository<Banda, Long>,
	JpaSpecificationExecutor<Banda> {

	Optional<Banda> findByNome(String nome);

}
