package com.bhusal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhusal.entity.Student;


public interface StudentRepo extends JpaRepository<Student, Long> {

}
