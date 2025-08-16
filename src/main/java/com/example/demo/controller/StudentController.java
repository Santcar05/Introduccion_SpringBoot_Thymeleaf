package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Student;

@RequestMapping("/student")
@Controller
public class StudentController {
    @GetMapping("/quemado")
    public String mostrarInformacionQuemada(Model model) {

        String nombre = "Juan";
        model.addAttribute("variable",nombre);
        model.addAttribute("numero",2);

        //Crear estudiante
        Student student = new Student(1, "Juan", "Perez", 3, "X3Y8S@example.com", "https://img.freepik.com/vector-premium/personaje-dibujos-animados-estudiante-escribiendo-papel-vector-libre_310181-81.jpg");
        model.addAttribute("estudiante", student);

        return "mostrarEstudiante";
    }

}