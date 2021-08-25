package com.gcc.crudbasico.api.form;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityExistsException;
import javax.validation.constraints.NotNull;

import com.gcc.crudbasico.api.model.Banda;
import com.gcc.crudbasico.api.model.Genero;
import com.gcc.crudbasico.api.repository.BandaRepository;
import com.gcc.crudbasico.api.repository.MusicoRepository;
import com.gcc.crudbasico.core.exception.GeneroInvalidoException;

import lombok.Data;

@Data
public class BandaForm {
	
	@NotNull
	private String nome;
	
	@NotNull
	private String genero;
	
	private List<IntegranteForm> integrantes;
	
	public Banda parse(BandaRepository bandaRepository, MusicoRepository musicoRepository) {
		Optional<Banda> opt = bandaRepository.findByNome(this.nome);
		if(opt.isPresent()) {
			throw new EntityExistsException("Banda já cadastrada");
		}
		var banda = new Banda();
		banda.setNome(this.nome);
		
		try {
			banda.setGenero(Genero.valueOf(this.genero));
		} catch(IllegalArgumentException e) {
			throw new GeneroInvalidoException(this.genero);
		}
		
		if( this.integrantes != null) {
			banda.setIntegrantes( this.integrantes
										.stream()
										.map(i -> i.parse(musicoRepository, banda))
										.collect(Collectors.toList())
										);
		}
		
		return banda;
	}
	
}
