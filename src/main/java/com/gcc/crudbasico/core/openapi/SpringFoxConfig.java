package com.gcc.crudbasico.core.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.gcc.crudbasico.api"))
					.build()
				.apiInfo(apiInfo())
				.tags(new Tag("BandaController", "Gerencia bandas de rock"));
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("CRUD Básico API")
				.description("API para demonstração de CRUD Básico")
				.version("1")
				.contact(new Contact("Thiago Segato", "https://github.com/ThiagoSegato", "thiago.segato@gmail.com"))
				.build();
	}
	
	
}
