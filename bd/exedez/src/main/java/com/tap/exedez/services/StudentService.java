package com.tap.exedez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tap.exedez.entities.Student;
import com.tap.exedez.repositories.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Estudante não cadastrado"));
    }

    public void deleteById(Long id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new EntityNotFoundException("Estudante não cadastrado");
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public void update(Student student, Long id) {
        Student s = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Estudante não cadastrado"));

        s.setName(student.getName());
        s.setEmail(student.getEmail());
        s.setCourse(student.getCourse());
        s.setRegistrationNumber(student.getRegistrationNumber());
        s.setAge(student.getAge());
        s.setActive(student.getActive());

        repository.save(s);
    }
}
