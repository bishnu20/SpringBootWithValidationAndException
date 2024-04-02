
/*
 * Author: Bishnu Bhusal
 * */
package com.bhusal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhusal.entity.Student;
import com.bhusal.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private final StudentService stuService;

	public StudentController(StudentService stuService) {
		super();
		this.stuService = stuService;
	}
	// add @Valid for validation
	@PostMapping("/stu")
	public ResponseEntity<?> addStudent(@Valid @RequestBody Student stu){
		Student student = stuService.addStudent(stu);
		return ResponseEntity.ok(student);
		
	}
	
	@GetMapping
	public List<Student> getAllStudents(){
		return stuService.getAllStudent();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return stuService.findStuById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStuById(@PathVariable Long id) {
		stuService.deleteStu(id);
		return ResponseEntity.ok().build();
	}

}
