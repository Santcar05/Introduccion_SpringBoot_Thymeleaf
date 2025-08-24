package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.entities.Homework;
import com.example.demo.entities.Student;
import com.example.demo.repository.HomeworkRepository;
import com.example.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        studentRepository.save(new Student("jose", "1234", 10, "X3Y8S@example.com", "https://img.freepik.com/vector-premium/personaje-dibujos-animados-estudiante-escribiendo-papel-vector-libre_310181-81.jpg"));
        studentRepository.save(new Student("pepe", "1234", 8, "X3Y8S@example.com", "https://img.freepik.com/vector-premium/personaje-dibujos-animados-estudiante-escribiendo-papel-vector-libre_310181-81.jpg"));
        studentRepository.save(new Student("camilo", "1234", 9, "X3Y8S@example.com", "https://img.freepik.com/vector-premium/personaje-dibujos-animados-estudiante-escribiendo-papel-vector-libre_310181-81.jpg"));

        homeworkRepository.save(new Homework("Tarea 1", "Detalles de la tarea 1"));
        homeworkRepository.save(new Homework("Tarea 2", "Detalles de la tarea 2"));
        homeworkRepository.save(new Homework("Tarea 3", "Detalles de la tarea 3"));

        Student asociar = studentRepository.findById(1L).get();
        for (Homework homework : homeworkRepository.findAll()) {
            //asociar.getTareas().add(homework); //No funciona por la represnetacion
            homework.setEstudiante(asociar);
            homeworkRepository.save(homework);
        }
    }
}
