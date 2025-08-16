package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    //Buena practica:  utilizar requestMapping en vez de colocar la url en el getMapping
@Controller
@RequestMapping("/mundo")
public class HolaMundoController {

    //Que tipo de peticion se estará haciendo
    @GetMapping("/hola")
    //@ResponseBody //Retornar codigo de html en la función(NO UTILIZAR CUANDO SE UTILIZA THYMELEAF)
    public String holaMundo() {
        return "holaMundo";//Sin la extension
    }

    @GetMapping("chao")
    public String chaoMundo() {
        return "chaoMundo";
    }

    //Solo puede haber una sola peticion get por url

}

//Thymeleaf: Motor de plantillas, relacionar codigos de html y java