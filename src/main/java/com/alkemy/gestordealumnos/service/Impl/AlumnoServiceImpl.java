package com.alkemy.gestordealumnos.service.Impl;

import com.alkemy.gestordealumnos.entities.AlumnoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoServiceImpl {

    List<AlumnoEntity>getAll();

    AlumnoEntity getById (int id) throws Exception;

    List<AlumnoEntity> saveAlumno (AlumnoEntity a);

    List<AlumnoEntity> delete(int id);

    List<AlumnoEntity> update(int id, AlumnoEntity alumno) throws Exception;

}
