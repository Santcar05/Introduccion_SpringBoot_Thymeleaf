package com.example.demo.repository;

import java.util.Collection;
import java.util.Map;

import javax.xml.crypto.Data;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student;
import com.sun.jdi.connect.Connector;

@Repository
public class StudentRepository {

    private Map<Integer, Student> estudiantes = new java.util.HashMap<Integer, Student>();

    public StudentRepository() {
        //Crear falsa base de Datos
        estudiantes.put(1, new Student(1, "Juan", "Perez", 3, "X3Y8S@example.com", "https://img.freepik.com/vector-premium/personaje-dibujos-animados-estudiante-escribiendo-papel-vector-libre_310181-81.jpg"));
        estudiantes.put(2, new Student(2, "Pedro", "Gonzalez", 3, "ABVG@example.com", "https://img.freepik.com/vector-premium/personaje-dibujos-animados-estudiante-escribiendo-papel-vector-libre_310181-81.jpg"));
        estudiantes.put(3, new Student(3, "Ana", "Garcia", 4, "X3Y8S@example.com", "https://img.freepik.com/vector-premium/personaje-dibujos-animados-estudiante-escribiendo-papel-vector-libre_310181-81.jpg"));
        estudiantes.put(4, new Student(4, "Maria", "Garcia", 4, "X3Y8S@example.com", "https://img.freepik.com/vector-premium/personaje-dibujos-animados-estudiante-escribiendo-papel-vector-libre_310181-81.jpg"));

    }

    //READ
    public Student findByIDStudent(Integer id) {
        return estudiantes.get(id);
    }

    public Collection<Student> findAll() {
        return estudiantes.values();
    }

    //CREATE
    public void save(Student student) {
        if (student.getId() == null) {
            int tam = estudiantes.size();
            int lastId = estudiantes.get(tam).getId();
            student.setId(lastId + 1);
            estudiantes.put(student.getId(), student);
        } else {
            estudiantes.put(student.getId(), student);
        }

    }

    //DELETE
    public void delete(Integer id) {
        estudiantes.remove(id);
    }
    //UPDATE
}

//TArea, conectarse a la BD
