package com.arking.learning_app;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.arking.persistent.repo")
@EntityScan("com.arking.persistent.model")
@SpringBootApplication
public class LearningAppApplication {

	public static void main(String[] args) {

        SpringApplication.run(LearningAppApplication.class, args);


	}

}
