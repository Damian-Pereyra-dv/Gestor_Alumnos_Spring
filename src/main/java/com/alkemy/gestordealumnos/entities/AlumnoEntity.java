package com.alkemy.gestordealumnos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor

public class AlumnoEntity {


    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private int calificacion;
    private boolean adeuraMaterias;
    private LocalDate fechaIngreso;
    private boolean abono;
    private String cursoAsociado;


    public AlumnoEntity() {

    }
}
