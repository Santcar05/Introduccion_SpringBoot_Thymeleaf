package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student searchByID(Integer id) {
        return studentRepository.findByIDStudent(id);
    }

    @Override
    public Collection<Student> searchAll() {
        return studentRepository.findAll();
    }

}