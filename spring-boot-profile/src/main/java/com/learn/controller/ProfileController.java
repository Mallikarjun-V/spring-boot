package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.dao.TestDao;

@RestController
public class ProfileController {
    
    @Autowired
    private TestDao testDao;
    
    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public ResponseEntity<?> getProfile() {
        System.out.println("Getting profile...");
        return ResponseEntity.ok(testDao.get());
    }
    
}
