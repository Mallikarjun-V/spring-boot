package com.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.dto.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
