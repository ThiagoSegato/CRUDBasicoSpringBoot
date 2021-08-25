package com.gcc.crudbasico.api.dto;

import com.gcc.crudbasico.api.model.Integrante;

import lombok.Getter;

@Getter
public class IntegranteDto {

	private final String banda;
	private final String nome;
	private final String apelido;
	private final String instrumento;
	
	public IntegranteDto(Integrante integrante) {
		this.banda = integrante.getBanda().getNome();
		this.nome = integrante.getMusico().getNome();
		this.apelido = integrante.getMusico().getApelido();
		this.instrumento = integrante.getInstrumento().toString();
	}
	
}
