package com.learn.student.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.student.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	List<Student> students = new ArrayList<>();

	@PostConstruct
	public void init() {
		Student s1 = new Student(1L, "John", "Cena");
		Student s2 = new Student(2L, "Stone", "Cold");
		Student s3 = new Student(1L, "The", "Rock");
		students.add(s1);
		students.add(s2);
		students.add(s3);
	}

	@RequestMapping("")
	public List<Student> getStudents() {
		LOGGER.info("Fetching Students");
		LOGGER.debug("Students: {}", students);
		return students;
	}
}
