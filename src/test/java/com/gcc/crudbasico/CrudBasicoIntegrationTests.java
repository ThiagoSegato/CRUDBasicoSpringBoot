package com.gcc.crudbasico;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityExistsException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.gcc.crudbasico.api.form.BandaForm;
import com.gcc.crudbasico.api.model.Genero;
import com.gcc.crudbasico.api.service.BandaService;
import com.gcc.crudbasico.core.exception.GeneroInvalidoException;

@SpringBootTest
@TestPropertySource(properties = { "spring.datasource.url=jdbc:h2:mem:test" })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CrudBasicoIntegrationTests {
	
	@Autowired
	private BandaService bandaService;
	
	@Test
	@Order(1)
	void deveAtribuirId_QuandoCadastrarBandaCorreta() {
		var form = new BandaForm();
		form.setNome("Ramones");
		form.setGenero(Genero.GRUNGE.toString());
		var novaBanda = bandaService.save(form);
		assertThat(novaBanda).isNotNull();
		assertThat(novaBanda.getId()).isNotNull();
	}
	
	@Test
	@Order(2)
	void deveFalhar_QuandoCadastrarBandaComMesmoNome() {
		assertThrows(EntityExistsException.class, () -> {
			var form = new BandaForm();
			form.setNome("Ramones");
			form.setGenero(Genero.GRUNGE.toString());
			bandaService.save(form);
		});	
	}
	
	@Test
	@Order(3)
	void deveFalhar_QuandoCadastrarBandaSertanejo() {
		assertThrows(GeneroInvalidoException.class, () -> {
			var form = new BandaForm();
			form.setNome("Luan Santana");
			form.setGenero("SERTANEJO");
			bandaService.save(form);
		});	
	}
	
}
