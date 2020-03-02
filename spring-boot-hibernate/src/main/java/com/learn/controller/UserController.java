package com.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.dto.User;
import com.learn.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> list() {
        return userService.list();
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }
}
