package com.learn.onetoone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public List<Employee> list() {
        return employeeRepository.findAll();
    }
    
    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }
    
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
