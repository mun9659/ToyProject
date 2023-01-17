package com.toyProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ToyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToyProjectApplication.class, args);
	}

}
