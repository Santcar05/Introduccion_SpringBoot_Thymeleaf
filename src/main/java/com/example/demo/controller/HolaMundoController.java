package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolaMundoController {
    //Que tipo de peticion se estará haciendo
    @GetMapping("/hola")
    //@ResponseBody //Retornar codigo de html en la función(NO UTILIZAR CUANDO SE UTILIZA THYMELEAF)
    public String holaMundo() {
        return "holaMundo";//Sin la extension
    }


    @GetMapping("/chao")
    public String chaoMundo() {
        return "chaoMundo";
    }

}

//Thymeleaf: Motor de plantillas, relacionar codigos de html y java