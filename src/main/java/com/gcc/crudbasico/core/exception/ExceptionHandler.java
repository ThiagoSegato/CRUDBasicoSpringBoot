package com.gcc.crudbasico.core.exception;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gcc.crudbasico.api.dto.ErroDto;

@RestControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErroDto notFoundHandler(EntityNotFoundException ex, HttpServletRequest req) {
		return new ErroDto(ex.getMessage(), req.getServletPath());
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(EntityExistsException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErroDto entityExistsHandler(EntityExistsException ex, HttpServletRequest req) {
		return new ErroDto(ex.getMessage(), req.getServletPath());
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErroDto validationHandler(HttpMessageNotReadableException ex, HttpServletRequest req) {
		return new ErroDto(ex.getMessage(), req.getServletPath());
	}
	
}
