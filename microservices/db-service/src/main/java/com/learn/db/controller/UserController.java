package com.learn.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.db.model.User;
import com.learn.db.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.getUsers();
	}
}
