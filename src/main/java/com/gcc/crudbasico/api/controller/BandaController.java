package com.gcc.crudbasico.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.gcc.crudbasico.api.dto.BandaDto;
import com.gcc.crudbasico.api.dto.IntegranteDto;
import com.gcc.crudbasico.api.filter.BandaFilter;
import com.gcc.crudbasico.api.form.BandaForm;
import com.gcc.crudbasico.api.form.IntegranteForm;
import com.gcc.crudbasico.api.model.Banda;
import com.gcc.crudbasico.api.repository.specification.BandaSpecification;
import com.gcc.crudbasico.api.service.BandaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "BandaController")
@RestController
@RequestMapping("/banda")
public class BandaController {

	@Autowired
	private BandaService bandaService;
		
	@ApiOperation("Lista todas as bandas com ou sem filtro")
	@GetMapping
	public Page<BandaDto> listar(BandaFilter filtro, @PageableDefault Pageable pageable){		
		Page<Banda> bandas = bandaService.findAll(BandaSpecification.usandoFiltro(filtro), pageable);		
		return bandas.map(BandaDto::new);		
	}
	
	@ApiOperation("Busca uma banda por Id")
	@GetMapping("/{id}")
	public BandaDto buscarPorId(@PathVariable("id") Banda banda){
		return new BandaDto(banda);
	}
	
	@ApiOperation("Cadastra uma banda, com ou sem integrantes")
	@PostMapping
	public ResponseEntity<BandaDto> adicionar(@RequestBody @Validated BandaForm form, UriComponentsBuilder uri) {
		var banda = bandaService.save(form);
		UriComponents uriComponents = uri.path("/banda/{id}").buildAndExpand(banda.getId());
		return ResponseEntity.created(uriComponents.toUri()).body(new BandaDto(banda));
	}

	@ApiOperation("Atualiza uma banda por Id")
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<BandaDto> alterar(@PathVariable("id") Banda banda, @RequestBody @Validated BandaForm form) {
		bandaService.update(banda, form);	
		return ResponseEntity.ok(new BandaDto(banda));
	}
	
	@ApiOperation("Exclui uma banda por Id")
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable("id") Banda banda) {
		bandaService.remove(banda);	
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Cadastra um integrante de uma banda por Id")
	@PostMapping("/{id}/integrante")
	public ResponseEntity<IntegranteDto> adicionarIntegrante(@PathVariable("id") Banda banda, @RequestBody @Validated IntegranteForm integranteForm) {
		var integrante = this.bandaService.insereIntegrante(banda, integranteForm);
		return ResponseEntity.ok(new IntegranteDto(integrante));
	}
	
}
