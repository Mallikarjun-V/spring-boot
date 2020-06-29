package com.learn.respository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.model.Role;
import com.learn.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findByUsername(String username);

	Boolean existsByRole(Role role);
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
