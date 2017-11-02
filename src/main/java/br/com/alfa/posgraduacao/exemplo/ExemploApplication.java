package br.com.alfa.posgraduacao.exemplo;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ExemploApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ExemploApplication.class, args);
	}
	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ExemploApplication.class);
	}
}
