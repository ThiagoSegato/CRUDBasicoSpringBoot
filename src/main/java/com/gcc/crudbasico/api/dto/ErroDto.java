package com.gcc.crudbasico.api.dto;

import lombok.Getter;

@Getter
public class ErroDto {

	private String mensagem;
	
	private String path;
	
	public ErroDto(String mensagem, String path) {
		this.mensagem = mensagem;
		this.path = path;
	}
	
}
