package com.learn.user.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.user.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	Optional<User> findByName(String name);

	boolean existsByName(String string);
}
