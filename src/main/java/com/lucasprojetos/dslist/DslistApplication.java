package com.lucasprojetos.dslist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DslistApplication {

	public static void main(String[] args) {
		SpringApplication.run(DslistApplication.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Running! Listening on http://localhost:8080");
        };
    }

}
