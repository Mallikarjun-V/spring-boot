package com.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.dto.Order;
import com.learn.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    private Order createOrder(@RequestBody Order order) {
        return orderService.save(order);
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    private List<Order> list() {
        return orderService.list();
    }
    
}
