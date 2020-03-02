package com.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
