package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dao.UserRepository;
import com.learn.dto.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User save(User user) {
        return userRepository.save(user);
    }
    
    public List<User> list() {
        return userRepository.findAll();
    }
}
