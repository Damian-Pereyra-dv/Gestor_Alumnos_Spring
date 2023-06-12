package com.alkemy.gestordealumnos.repository;

import com.alkemy.gestordealumnos.entities.AlumnoEntity;
import com.alkemy.gestordealumnos.entities.CursoEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository {


    public List<CursoEntity> cursos = new ArrayList<>();
    public List<AlumnoEntity> alumnos = new ArrayList<>();

    public AlumnoEntity alumno = new AlumnoEntity();


    public void crearCursos() {// Crear cursos c

        cursos.add(new CursoEntity(1L, "Java", "Curso de Java", 60));
        cursos.add(new CursoEntity(2L, "Python", "Curso de Python", 45));
        cursos.add(new CursoEntity(3L, "Php", "Curso de PHP", 30));

    }


}
