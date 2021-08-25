package com.gcc.crudbasico.api.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="banda_integrantes")
public class Integrante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Banda banda;
	
	@ManyToOne
	private Musico musico;
	
	@Enumerated(EnumType.STRING)
	private Instrumento instrumento;
	
	public Integrante(Banda banda, Musico musico, Instrumento instrumento) {
		this.banda = banda;
		this.musico = musico;
		this.instrumento = instrumento;
	}
	
}
