package com.gcc.crudbasico.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcc.crudbasico.api.form.BandaForm;
import com.gcc.crudbasico.api.form.IntegranteForm;
import com.gcc.crudbasico.api.model.Banda;
import com.gcc.crudbasico.api.model.Genero;
import com.gcc.crudbasico.api.model.Integrante;
import com.gcc.crudbasico.api.repository.BandaRepository;
import com.gcc.crudbasico.api.repository.IntegranteRepository;
import com.gcc.crudbasico.api.repository.MusicoRepository;

@Service
public class BandaService {

	@Autowired
	private BandaRepository bandaRepository;
	
	@Autowired
	private MusicoRepository musicoRepository;
	
	@Autowired
	private IntegranteRepository integranteRepository;
	
	public Page<Banda> findAll(Specification<Banda> specification, Pageable pageable) {
		return bandaRepository.findAll(specification, pageable);
	}
	
	public Banda getById(Long id) {
		return bandaRepository.getById(id);
	}
	
	public Banda save(BandaForm form) {
		Banda banda = form.parse(bandaRepository, musicoRepository);	
		bandaRepository.save(banda);
		return banda;
	}
	
	@Transactional
	public void update(Banda banda, BandaForm form) {
		banda.setNome(form.getNome());
		banda.setGenero(Genero.valueOf(form.getGenero()));
	}

	@Transactional
	public void remove(Banda banda) {
		this.bandaRepository.delete(banda);
	}

	public Integrante insereIntegrante(Banda banda, IntegranteForm integranteForm) {
		var integrante = integranteForm.parse(this.musicoRepository, banda);
		this.integranteRepository.save(integrante);
		return integrante;
	}
	
}
