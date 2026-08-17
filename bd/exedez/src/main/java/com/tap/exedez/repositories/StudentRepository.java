package com.tap.exedez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tap.exedez.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
