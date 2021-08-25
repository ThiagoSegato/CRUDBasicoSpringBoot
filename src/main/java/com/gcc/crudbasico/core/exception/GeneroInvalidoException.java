package com.gcc.crudbasico.core.exception;

import com.gcc.crudbasico.core.i18n.Translator;

public class GeneroInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GeneroInvalidoException(String genero) {
		super(Translator.toLocale("exception.genero.invalido", new String[]{genero}));
	}
	
}
