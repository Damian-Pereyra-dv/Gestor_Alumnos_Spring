package com.alkemy.gestordealumnos.service.Impl;

import com.alkemy.gestordealumnos.entities.AlumnoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoServiceImpl {

    List<AlumnoEntity>getAll();

    AlumnoEntity getById (int id) throws Exception;

    List<AlumnoEntity> saveAlumno (AlumnoEntity a);


}
