package com.alkemy.gestordealumnos.service;

import com.alkemy.gestordealumnos.entities.AlumnoEntity;
import com.alkemy.gestordealumnos.exceptions.NoEncontradoException;
import com.alkemy.gestordealumnos.exceptions.errorMensajes.ErrorMensaje;
import com.alkemy.gestordealumnos.repository.AlumnoRepository;
import com.alkemy.gestordealumnos.service.Impl.AlumnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


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
    public AlumnoEntity getById(int id) throws Exception {
        AlumnoEntity alumnoEntity = alumnoRepository.alumnos.stream().filter(alumno -> alumno.getId() == id).findFirst().orElse(null);
        if (alumnoEntity == null) {
            throw new NoEncontradoException(ErrorMensaje.ALUMNO_NO_ENCONTRADO);
        }
        return alumnoEntity;
    }

    @Override
    public List<AlumnoEntity> saveAlumno(AlumnoEntity a) {
        (alumnoRepository.alumnos).add(a);

        return alumnoRepository.alumnos;
    }

    @Override
    public List<AlumnoEntity> delete(int id) {
        (alumnoRepository.alumnos).removeIf(alumno -> alumno.getId() == id);
        return alumnoRepository.alumnos;
    }

    @Override
    public List<AlumnoEntity> update(int id, AlumnoEntity alumno) throws Exception {

        AlumnoEntity alumnoViejo = (alumnoRepository.alumnos).stream().filter(alum-> alum.getId() == id).findFirst().orElse(null);
        if (Objects.isNull(alumnoViejo)) {
            throw new NoEncontradoException(ErrorMensaje.ALUMNO_NO_ENCONTRADO);
        }

        (alumnoRepository.alumnos).remove(alumnoViejo);
        alumno.setId(id);
        (alumnoRepository.alumnos).add(alumno);
        return (alumnoRepository.alumnos);
    }


}
