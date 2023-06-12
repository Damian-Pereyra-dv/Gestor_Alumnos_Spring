package com.alkemy.gestordealumnos.controller;

import com.alkemy.gestordealumnos.entities.AlumnoEntity;
import com.alkemy.gestordealumnos.entities.CursoEntity;
import com.alkemy.gestordealumnos.exceptions.NoEncontradoException;
import com.alkemy.gestordealumnos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/cursos")
public class CursoController {

    @Autowired
    public CursoService cursoService;

    @GetMapping
    public List<CursoEntity> getAll (){
        return cursoService.getAll();
    }
    @GetMapping("/{curso}")
    public List<AlumnoEntity> obtenerAlumnosPorCurso(@PathVariable String curso) {
        return cursoService.obtenerAlumnosPorCurso(curso);
    }


    @ExceptionHandler(NoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNoEncontradoException(NoEncontradoException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("mensaje", ex.getMessage());
        return errorResponse;
    }


}
