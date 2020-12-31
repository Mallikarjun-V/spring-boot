package com.learn.db.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.db.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	Optional<User> findByName(String name);

	boolean existsByName(String string);
}
