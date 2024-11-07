package com.reserva.unipamplona.reserva.unipamplona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.reserva.unipamplona.reserva.unipamplona.model")
@EnableJpaRepositories(basePackages = "com.reserva.unipamplona.reserva.unipamplona.Repository")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
