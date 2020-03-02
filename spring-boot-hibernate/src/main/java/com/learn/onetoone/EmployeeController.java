package com.learn.onetoone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> list() {
        return employeeService.list();
    }
    
    @RequestMapping(method = RequestMethod.GET, params = { "id" })
    public Employee findById(@RequestParam("id") Long id) {
        return employeeService.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
    
}
