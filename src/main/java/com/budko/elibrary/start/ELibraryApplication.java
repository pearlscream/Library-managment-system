package com.budko.elibrary.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.budko.elibrary")
@EnableJpaRepositories("com.budko.elibrary.repositories")
@EntityScan("com.budko.elibrary.entities")
public class ELibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ELibraryApplication.class, args);
	}
}
