package com.learn.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.learn.user.model.User;
import com.learn.user.repository.UserRepository;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			boolean sachinExists = userRepository.existsByName("Sachin");
			if (!sachinExists) {
				userRepository.save(new User("Sachin", "India"));
			}
			boolean dravidExists = userRepository.existsByName("Dravid");
			if (!dravidExists) {
				userRepository.save(new User("Dravid", "India"));
			}
		};
	}

}
