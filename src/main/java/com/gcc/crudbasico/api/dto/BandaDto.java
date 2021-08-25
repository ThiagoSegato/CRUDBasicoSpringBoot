package com.gcc.crudbasico.api.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.gcc.crudbasico.api.model.Banda;

import lombok.Getter;

@Getter
public class BandaDto {

	private final Long id;
	
	private final String nome;
	
	private final String genero;
	
	private final List<String> integrantes;
	
	public BandaDto(Banda banda) {
		this.id = banda.getId();
		this.nome = banda.getNome();
		this.genero = banda.getGenero().getDescricao();
		this.integrantes = banda.getIntegrantes().stream().map(i -> i.getMusico().getApelido()+ " - "+ i.getInstrumento()).collect(Collectors.toList());
	}
	
}

