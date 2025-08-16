package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok: Facilitar código template
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer semestre;
    private String correo;
    private String imagenURL;
}

