package com.gcc.crudbasico.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.crudbasico.api.model.Musico;

public interface MusicoRepository extends JpaRepository<Musico, Long> {

	Musico findByApelido(String musicoApelido);

}
