package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration: Declarar benas en este archivo
//EnableAutoConfiguration: Activar la configuracion automatica de las dependencias del pom
//ComponentScan: Buscar componentes en el paquete raiz
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

//Patron :Buscar única responsabilidad
//Patron de Capas:

//---Controlador---
//---Servicio---
//---Repositorio---