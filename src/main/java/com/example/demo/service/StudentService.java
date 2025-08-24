package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entities.Student;

public interface StudentService {

    public Collection<Student> searchAll();

    public void save(Student student);

}
