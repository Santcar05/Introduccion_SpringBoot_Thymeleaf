package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;

@RequestMapping("/student")
@Controller
public class StudentController {

    @Autowired
    private Student estudiante2; //toma el bean del mismo nombre por el autowired

    @Autowired
    private StudentService service;

    Logger looger = LoggerFactory.getLogger(StudentController.class);

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

    //http://localhost:8080/student/1
    @GetMapping("/{id}")
    public String getMethodName(Model model, @PathVariable("id") Integer identificador) {
        Student student = service.searchByID(identificador);
        model.addAttribute("estudiante", student);

        return "mostrarEstudiante";
    }

    //Utilizar este cuando son consultas complejas
    //http://localhost:8080/student?id=1
    @GetMapping(params = "id")
    public String getMethodName2(Model model, @RequestParam("id") Integer identificador) {
        Student student = service.searchByID(identificador);
        model.addAttribute("estudiante", student);

        return "mostrarEstudiante";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {

        Student student = new Student(null, "", "", null, "", "");
        model.addAttribute("estudiante", student);

        return "crearEstudiante";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Integer identificador) {
        service.delete(identificador);
        return "redirect:/student";
    }

    //En el parametro usar ModelAttribute para tomar la info que viene por el cuerpo de la peticion
    @PostMapping("/add")
    public String agregarEstudiante(@ModelAttribute("estudiante") Student student) {
        looger.info(student.getId() + " " + student.getNombre() + " " + student.getApellido() + " " + student.getSemestre() + " " + student.getCorreo());
        service.save(student);
        return "redirect:/student";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioActualizar(Model model, @PathVariable("id") Integer identificador) {
        Student student = service.searchByID(identificador);
        model.addAttribute("estudiante", student);
        return "crearEstudiante";
    }

}
