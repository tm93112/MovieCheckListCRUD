package com.tomas.moviechecklist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MoviechecklistApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviechecklistApplication.class, args);
	}
}
