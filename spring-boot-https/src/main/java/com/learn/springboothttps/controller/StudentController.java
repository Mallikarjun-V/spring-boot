package com.learn.springboothttps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboothttps.model.Student;
import com.learn.springboothttps.service.StudentService;

/**
 * Student Controller
 * 
 * @author MALLIKARJUN
 *
 */
@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		studentService.createStudent();
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Object> getStudents() {
		List<Student> students = studentService.getStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
}
