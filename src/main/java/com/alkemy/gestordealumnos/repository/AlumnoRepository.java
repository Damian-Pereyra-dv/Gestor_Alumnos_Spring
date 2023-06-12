package com.alkemy.gestordealumnos.repository;

import com.alkemy.gestordealumnos.entities.AlumnoEntity;
import com.alkemy.gestordealumnos.entities.CursoEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AlumnoRepository {


    public  List<AlumnoEntity> alumnos = new ArrayList<>();

    public void crearAlumnos() {// Crear alumnos con fechas específicas
        alumnos.add(new AlumnoEntity(1, "Juan", "Pérez", 20, 8, true, LocalDate.of(2022, 1, 15), true, "Java"));
        alumnos.add(new AlumnoEntity(2, "María", "Gómez", 22, 9, false, LocalDate.of(2022, 2, 28), true, "Python"));
        alumnos.add(new AlumnoEntity(3, "Carlos", "López", 19, 7, true, LocalDate.of(2022, 3, 12), false, "Php"));
        alumnos.add(new AlumnoEntity(4, "Laura", "Rodríguez", 21, 10, false, LocalDate.of(2022, 4, 5), false, "Python"));
        alumnos.add(new AlumnoEntity(5, "Pedro", "Martínez", 18, 7,true, LocalDate.of(2022, 5, 20), true, "Java"));
        alumnos.add(new AlumnoEntity(6, "Ana", "Hernández", 23, 4,false, LocalDate.of(2022, 6, 10), false, "Php"));
        alumnos.add(new AlumnoEntity(7, "Luis", "Torres", 20, 6,true, LocalDate.of(2022, 7, 8), true, "Python"));
        alumnos.add(new AlumnoEntity(8, "Sofía", "Silva", 19, 8,false, LocalDate.of(2022, 8, 14), false, "Php"));
        alumnos.add(new AlumnoEntity(9, "Diego", "Vargas", 22, 9,true, LocalDate.of(2022, 9, 18), true, "Java"));
        alumnos.add(new AlumnoEntity(10, "Mónica", "Rojas", 21, 5,false, LocalDate.of(2022, 10, 25), true, "Java"));




    }



}



