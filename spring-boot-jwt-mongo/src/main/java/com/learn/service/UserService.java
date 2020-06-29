package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.model.User;
import com.learn.respository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	public User createUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public User getUser(String userId) {
		return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
	}

	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}
}
