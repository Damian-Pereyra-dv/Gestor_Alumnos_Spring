package com.alkemy.gestordealumnos.service;

import com.alkemy.gestordealumnos.entities.AlumnoEntity;
import com.alkemy.gestordealumnos.entities.CursoEntity;
import com.alkemy.gestordealumnos.exceptions.NoEncontradoException;
import com.alkemy.gestordealumnos.exceptions.errorMensajes.ErrorMensaje;
import com.alkemy.gestordealumnos.repository.AlumnoRepository;
import com.alkemy.gestordealumnos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private final CursoRepository cursoRepository;
    @Autowired
    private final AlumnoRepository alumnoRepository;


    public CursoService(CursoRepository cursoRepository, AlumnoRepository alumnoRepository) {
        this.cursoRepository = cursoRepository;
        this.alumnoRepository = alumnoRepository;
        cursoRepository.crearCursos();
    }


    public List<CursoEntity> getAll() {
        return cursoRepository.cursos;
    }


    public List<AlumnoEntity> obtenerAlumnosPorCurso(String curso) throws NoEncontradoException {
        List<AlumnoEntity> alumnosPorCurso = alumnoRepository.alumnos.stream()
                .filter(alumno -> alumno.getCursoAsociado().equalsIgnoreCase(curso))
                .collect(Collectors.toList());

        if (alumnosPorCurso.isEmpty()) {
            throw new NoEncontradoException(ErrorMensaje.CURSO_NO_ENCONTRADO);
        }

        return alumnosPorCurso;
    }

}
