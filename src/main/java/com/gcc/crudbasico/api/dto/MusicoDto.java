package com.gcc.crudbasico.api.dto;

import com.gcc.crudbasico.api.model.Musico;

import lombok.Getter;

@Getter
public class MusicoDto {

	private String nome;
	
	private String apelido;
	
	public MusicoDto(Musico musico) {
		this.nome = musico.getNome();
		this.apelido = musico.getApelido();
	}
	
}
