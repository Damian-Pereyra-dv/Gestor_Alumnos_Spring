package com.alkemy.gestordealumnos.service;

import com.alkemy.gestordealumnos.entities.AlumnoEntity;
import com.alkemy.gestordealumnos.exceptions.NoEncontradoException;
import com.alkemy.gestordealumnos.exceptions.errorMensajes.ErrorMensaje;
import com.alkemy.gestordealumnos.repository.AlumnoRepository;
import com.alkemy.gestordealumnos.service.Impl.AlumnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class AlumnoService implements AlumnoServiceImpl {

    @Autowired
    private final AlumnoRepository alumnoRepository;


    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
        alumnoRepository.crearAlumnos();
    }

    @Override
    public List<AlumnoEntity> getAll() {
        return alumnoRepository.alumnos;
    }

    @Override
    public AlumnoEntity getById(int id) {
        return buscarAlumnoPorId(id);
    }

    @Override
    public List<AlumnoEntity> saveAlumno(AlumnoEntity a) {
        alumnoRepository.alumnos.add(a);
        return alumnoRepository.alumnos;
    }

    @Override
    public List<AlumnoEntity> delete(int id) {
        alumnoRepository.alumnos.removeIf(alumno -> alumno.getId() == id);
        return alumnoRepository.alumnos;
    }

    @Override
    public List<AlumnoEntity> update(int id, AlumnoEntity alumno) {
        AlumnoEntity alumnoViejo = buscarAlumnoPorId(id);
        int index = alumnoRepository.alumnos.indexOf(alumnoViejo);
        alumno.setId(id);
        alumnoRepository.alumnos.set(index, alumno);
        return alumnoRepository.alumnos;
    }

    @Override
    public String getAlumnoNotaMasAlta() {
        List<AlumnoEntity> alumnos = alumnoRepository.alumnos;

        int maxNota = alumnos.stream()
                .mapToInt(AlumnoEntity::getCalificacion)
                .max()
                .orElse(0);

        List<String> nombresApellidos = alumnos.stream()
                .filter(alumno -> alumno.getCalificacion() == maxNota)
                .map(alumno -> alumno.getNombre() + " " + alumno.getApellido())
                .collect(Collectors.toList());

        String resultado = "Calificación más alta: " + maxNota + "\n\n";
        resultado += "Alumnos con la calificación más alta:\n";
        resultado += String.join("\n", nombresApellidos);

        return resultado;
    }

    @Override
    public List<String> getAbono() {
        return alumnoRepository.alumnos.stream()
                .filter(alumno -> !alumno.isAbono())
                .map(alumno -> alumno.getId() + " " + alumno.getNombre() + " " + alumno.getApellido())
                .collect(Collectors.toList());
    }

    private AlumnoEntity buscarAlumnoPorId(int id) {
        return alumnoRepository.alumnos.stream()
                .filter(alumno -> alumno.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoEncontradoException(ErrorMensaje.ALUMNO_NO_ENCONTRADO));
    }
}
