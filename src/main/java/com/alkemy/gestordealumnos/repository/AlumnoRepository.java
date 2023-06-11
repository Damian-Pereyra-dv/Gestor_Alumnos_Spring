package com.alkemy.gestordealumnos.repository;

import com.alkemy.gestordealumnos.entities.AlumnoEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AlumnoRepository {
    public  List<AlumnoEntity> alumnos = new ArrayList<>();

    public void crearAlumnos() {// Crear alumnos con fechas específicas
        alumnos.add(new AlumnoEntity(1, "Juan", "Pérez", 20, LocalDate.of(2022, 1, 15), "Java"));
        alumnos.add(new AlumnoEntity(2, "María", "Gómez", 22, LocalDate.of(2022, 2, 28), "Python"));
        alumnos.add(new AlumnoEntity(3, "Carlos", "López", 19, LocalDate.of(2022, 3, 12), "Php"));
        alumnos.add(new AlumnoEntity(4, "Laura", "Rodríguez", 21, LocalDate.of(2022, 4, 5), "Python"));
        alumnos.add(new AlumnoEntity(5, "Pedro", "Martínez", 18, LocalDate.of(2022, 5, 20), "Java"));
        alumnos.add(new AlumnoEntity(6, "Ana", "Hernández", 23, LocalDate.of(2022, 6, 10), "Php"));
        alumnos.add(new AlumnoEntity(7, "Luis", "Torres", 20, LocalDate.of(2022, 7, 8), "Python"));
        alumnos.add(new AlumnoEntity(8, "Sofía", "Silva", 19, LocalDate.of(2022, 8, 14), "Php"));
        alumnos.add(new AlumnoEntity(9, "Diego", "Vargas", 22, LocalDate.of(2022, 9, 18), "Java"));
        alumnos.add(new AlumnoEntity(10, "Mónica", "Rojas", 21, LocalDate.of(2022, 10, 25), "Java"));


    }

}



