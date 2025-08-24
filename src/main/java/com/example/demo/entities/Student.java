package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//lombok: Facilitar código template
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private Integer semestre;
    private String correo;
    private String imagenURL;

    public Student() {
    }

    public Student(Long id, String nombre, String apellido, Integer semestre, String correo, String imagenURL) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestre = semestre;
        this.correo = correo;
        this.imagenURL = imagenURL;
    }

    //IMPORTANTE PARA USAR JPA TENER UN CONSTRUCTOR CON TODOS LOS CAMPOS MENOS EL ID Y OTRO SIN PARAMETROS
        public Student( String nombre, String apellido, Integer semestre, String correo, String imagenURL) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestre = semestre;
        this.correo = correo;
        this.imagenURL = imagenURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

}

