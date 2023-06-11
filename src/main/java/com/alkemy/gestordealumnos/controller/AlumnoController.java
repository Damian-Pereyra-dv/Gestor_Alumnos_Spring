package com.alkemy.gestordealumnos.controller;


import com.alkemy.gestordealumnos.entities.AlumnoEntity;
import com.alkemy.gestordealumnos.exceptions.NoEncontradoException;
import com.alkemy.gestordealumnos.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/alumnos")
public class AlumnoController {


    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<AlumnoEntity> getAll() {
        return alumnoService.getAll();
    }

    @GetMapping("/{id}")

    public AlumnoEntity getById(@PathVariable int id) throws Exception {
        return alumnoService.getById(id);
    }

    @GetMapping("/deudores")
    public List<String> abonaron() {
        return alumnoService.getAbono();
    }

    @GetMapping("/nota_mayor")
    public String getNotaMayor() {
        return alumnoService.getAlumnoNotaMasAlta();
    }


    @PostMapping("/add")
    public List<AlumnoEntity> saveAlumno(@RequestBody AlumnoEntity alumno) {
        return alumnoService.saveAlumno(alumno);
    }


    @DeleteMapping("/{id}")
    public List<AlumnoEntity> deleteByPosition(@PathVariable int id) {
        return alumnoService.delete(id);
    }

    @PutMapping("/{id}")

    public List<AlumnoEntity> update(@PathVariable int id, @RequestBody AlumnoEntity alumno) throws Exception {
        return alumnoService.update(id, alumno);
    }


    @ExceptionHandler(NoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNoEncontradoException(NoEncontradoException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("mensaje", ex.getMessage());
        return errorResponse;
    }


}



