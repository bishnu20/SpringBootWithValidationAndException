package com.bhusal.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bhusal.entity.Student;
import com.bhusal.exception.StudentNotFoundEx;
import com.bhusal.repo.StudentRepo;

@Service
public class StudentService {

	StudentRepo stuRepo;

	public StudentService(StudentRepo stuRepo) {
		super();
		this.stuRepo = stuRepo;
	}
	
	public Student addStudent(Student stu) {
		return stuRepo.save(stu);
	}
	public java.util.List<Student> getAllStudent(){
		return stuRepo.findAll();
	}
	
	public Student findStuById(Long id) {
		Optional<Student> student = stuRepo.findById(id);
		if (!student.isPresent()) {
			throw new StudentNotFoundEx(id);
			
		}
		
		return student.get() ;
	}
	
	public void deleteStu(Long id) {
		if (!stuRepo.existsById(id)) {
			throw new StudentNotFoundEx(id);
		}
		stuRepo.deleteById(id);
		
		
	}

}
