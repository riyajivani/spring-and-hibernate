package com.example.SecurityImpl.repository;

import com.example.SecurityImpl.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> { }
