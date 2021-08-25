package com.gcc.crudbasico.api.model;

public enum Genero {

	GRUNGE("Grunge"), PUNK("Punk Rock"), METAL("Metal");
	
	private String descricao;
	
	private Genero(String descricao) {
		this.descricao =  descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
