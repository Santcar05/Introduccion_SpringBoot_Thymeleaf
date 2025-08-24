package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Student;

//@Configuration: Declarar benas en este archivo
//EnableAutoConfiguration: Activar la configuracion automatica de las dependencias del pom
//ComponentScan: Buscar componentes en el paquete raiz
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean/*Objetos globales que pueden ser accedios en cualquier parte del proeycto */
    public Student estudiante() {
        return new Student("Ana", "García", 4, "X3Y8S@example.com", "https://img.freepik.com/vector-premium/personaje-dibujos-animados-estudiante-escribiendo-papel-vector-libre_310181-81.jpg");
    }

    @Bean/*Objetos globales que pueden ser accedios en cualquier parte del proeycto */
    public Student estudiante2() {
        return new Student("Pedro", "Gonzalez", 4, "ABVG@example.com", "https://img.freepik.com/vector-premium/personaje-dibujos-animados-estudiante-escribiendo-papel-vector-libre_310181-81.jpg");
    }

}

//Patron :Buscar única responsabilidad
//Patron de Capas:
//---Controlador---
//---Servicio---
//---Repositorio---
