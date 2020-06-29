package com.learn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.learn.model.Role;
import com.learn.model.User;
import com.learn.respository.UserRepository;

@SpringBootApplication
public class SpringBootJwtMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtMongoApplication.class, args);
	}

	// Creates default ADMIN User in DB if no ADMIN User exists.
	@Bean
	CommandLineRunner init(UserRepository userRepository, PasswordEncoder encoder) {

		return args -> {

			boolean adminUserExists = userRepository.existsByRole(Role.ROLE_ADMIN);
			System.out.println("ADMIN User Exists : " + adminUserExists);
			if (!adminUserExists) {
				User newAdminUser = new User();
				newAdminUser.setUsername("admin");
				newAdminUser.setEmail("admin@test.com");
				newAdminUser.setPassword(encoder.encode("password"));
				newAdminUser.setRole(Role.ROLE_ADMIN);
				userRepository.save(newAdminUser);
			}
		};

	}

}
