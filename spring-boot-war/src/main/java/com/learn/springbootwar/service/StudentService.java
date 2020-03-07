package com.learn.springbootwar.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.learn.springbootwar.exception.ApiException;
import com.learn.springbootwar.model.Student;

/**
 * Student Service
 * 
 * @author MALLIKARJUN
 *
 */
@Service
public class StudentService {

	public void createStudent() {
		throw new ApiException("Failed to create Student!"); // throwing exception for testing
	}

	public List<Student> getStudents() {
		try {
			// fetch students
			throw new ApiException("Failed to create Student!", HttpStatus.INTERNAL_SERVER_ERROR);// throwing exception
																									// for testing
		} catch (Exception e) {
			System.out.println("Error occured while fetching students");
			throw e;
		}
	}
}
