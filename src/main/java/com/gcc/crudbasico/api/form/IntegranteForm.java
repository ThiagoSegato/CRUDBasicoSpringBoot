package com.gcc.crudbasico.api.form;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.gcc.crudbasico.api.model.Banda;
import com.gcc.crudbasico.api.model.Instrumento;
import com.gcc.crudbasico.api.model.Integrante;
import com.gcc.crudbasico.api.model.Musico;
import com.gcc.crudbasico.api.repository.MusicoRepository;

import lombok.Getter;


@Getter
public class IntegranteForm {
	
	private Long musicoId = 0l;
	
	private String musicoApelido;
	
	@NotNull
	private Instrumento instrumento;
	
	public Integrante parse(MusicoRepository repositorio, Banda banda) {
		var musico = this.buscaMusico(repositorio);		
		return new Integrante(banda, musico, this.instrumento);		
	}
	
	private Musico buscaMusico(MusicoRepository repositorio) {
		Optional<Musico> optional = repositorio.findById(this.musicoId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return repositorio.findByApelido(this.musicoApelido);
	}

}
