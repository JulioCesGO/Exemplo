package br.com.alfa.posgraduacao.exemplo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"br.com.alfa.posgraduacao.exemplo.repositorio"})
public class ExemploApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ExemploApplication.class, args);
	}
	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ExemploApplication.class);
	}
}
