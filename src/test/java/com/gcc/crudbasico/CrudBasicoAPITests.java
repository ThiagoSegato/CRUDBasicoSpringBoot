package com.gcc.crudbasico;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import com.gcc.crudbasico.util.ResourceUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "spring.datasource.url=jdbc:h2:mem:test" })
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CrudBasicoAPITests {
	
	@LocalServerPort
	private int port;
	
	private String jsonBandaMetal;
	private String jsonBandaGrunge;
	private String jsonBandaSertanejo;
	
	@BeforeEach
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/banda";
		jsonBandaMetal = ResourceUtils.getContentFromResource("/json/banda_metal.json");
		jsonBandaGrunge = ResourceUtils.getContentFromResource("/json/banda_grunge.json");
		jsonBandaSertanejo = ResourceUtils.getContentFromResource("/json/banda_sertanejo.json");
	}
	
	@Test
	@Order(1)
	void deveRetornarStatus201_QuandoCadastrarBandaGrunge() {
		given()
			.body(jsonBandaMetal)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}
	
	@Test
	@Order(2)
	void deveRetornarStatus500_QuandoCadastrarBandaSertanejo() {
		given()
			.body(jsonBandaSertanejo)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	@Test
	@Order(3)
	void deveRetornarStatus400_QuandoCadastrarBandaNula() {
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	@Order(4)
	public void deveRetornarStatus200_QuandoConsultarBandas() {
		given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value())
			.body("content", hasSize(5));
	}
	
	@Test
	@Order(5)
	void deveRetornarStatus200_QuandoAlterarBanda() {
		given()
			.pathParam("id", 5)
			.body(jsonBandaGrunge)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.put("/{id}")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	@Order(6)
	public void deveRetornarStatus200_QuandoExcluiBanda() {
		given()
			.pathParam("id", 5)
			.accept(ContentType.JSON)
		.when()
			.delete("/{id}")
		.then()
			.statusCode(HttpStatus.NO_CONTENT.value());
	}
	
}
