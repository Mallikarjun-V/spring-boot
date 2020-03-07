package com.learn.springbootjetty.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.learn.springbootjetty.exception.ApiException;
import com.learn.springbootjetty.model.Student;

@Service
public class StudentService {

	public void createStudent() {
		throw new ApiException("Failed to create Student!"); // throwing exception for testing
	}

	public List<Student> getStudents() {
		try {
			// fetch students
			throw new ApiException("Failed to create Student!", HttpStatus.INTERNAL_SERVER_ERROR);// throwing exception for testing
		} catch (Exception e) {
			System.out.println("Error occured while fetching students");
			throw e;
		}
	}
}
