package com.learn.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.model.User;
import com.learn.service.UserService;

@RestController()
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createUser(@RequestBody User user) throws URISyntaxException {
		user = userService.createUser(user);
		return ResponseEntity.created(new URI("/users/" + user.getId())).build();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getUsers() throws URISyntaxException {
		List<User> users = userService.getUsers();
		return ResponseEntity.ok(users);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{user-id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> getUser(@PathVariable("user-id") String userId) {
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{user-id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteUser(@PathVariable("user-id") String userId) {
		userService.deleteUser(userId);
		return ResponseEntity.noContent().build();
	}
}
