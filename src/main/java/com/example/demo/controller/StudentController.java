package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;

@RequestMapping("/student")
@Controller
public class StudentController {

    @Autowired
    private Student estudiante2; //toma el bean del mismo nombre por el autowired

    @Autowired
    private StudentService service;

    @GetMapping("/quemado")
    public String mostrarInformacionQuemada(Model model) {

        String nombre = "Juan";
        model.addAttribute("variable", nombre);
        model.addAttribute("numero", 2);

        //Crear estudiante
        Student student = new Student(1, "Juan", "Perez", 3, "X3Y8S@example.com", "https://img.freepik.com/vector-premium/personaje-dibujos-animados-estudiante-escribiendo-papel-vector-libre_310181-81.jpg");
        model.addAttribute("estudiante", student);

        return "mostrarEstudiante";
    }

    @GetMapping("/bean")
    public String mostrarInformacionBean(Model model) {

        model.addAttribute("estudiante", estudiante2);

        return "mostrarEstudiante";
    }

    @GetMapping()
    public String mostrarEstudiantes(Model model) {

        model.addAttribute("estudiantes", service.searchAll());

        return "mostrarTodosEstudiantes";
    }

    @GetMapping("/{id}")
    public String getMethodName(Model model, @PathVariable("id") Integer identificador) {
        Student student = service.searchByID(identificador);
        model.addAttribute("estudiante", student);

        return "mostrarEstudiante";
    }

}
