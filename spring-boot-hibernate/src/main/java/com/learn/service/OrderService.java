package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dao.OrderRepository;
import com.learn.dto.Order;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public Order save(Order order) {
        return orderRepository.save(order);
    }
    
    public List<Order> list() {
        return orderRepository.findAll();
    }
}
