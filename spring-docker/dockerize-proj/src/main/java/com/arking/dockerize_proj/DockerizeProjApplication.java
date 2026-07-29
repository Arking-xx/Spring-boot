package com.arking.dockerize_proj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DockerizeProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerizeProjApplication.class, args);

	}

    @Bean
    CommandLineRunner testData(UserRepository userRepository){
        return args -> {
            User u = new User();
            u.setFirstName("chen");
            u.setLastName("long");
            userRepository.save(u);
            System.out.println("Saved user: " + u);
        };
    }


}
