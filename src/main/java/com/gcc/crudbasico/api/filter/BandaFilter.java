package com.gcc.crudbasico.api.filter;

import com.gcc.crudbasico.api.model.Genero;

import lombok.Data;

@Data
public class BandaFilter {
	
	private String nome;
	private Genero genero;
		
}
