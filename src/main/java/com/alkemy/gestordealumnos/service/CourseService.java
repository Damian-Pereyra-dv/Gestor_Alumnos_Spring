package com.alkemy.gestordealumnos.service;


import com.alkemy.gestordealumnos.entities.CourseEntity;

import java.util.List;
import java.util.Optional;

public interface CourseService {


    List<CourseEntity> getAll();

    Optional<CourseEntity> getById(int id) throws Exception;

    List<CourseEntity> saveCourse(CourseEntity a);

    List<CourseEntity> delete(int id);

    List<CourseEntity> update(int id, CourseEntity course) throws Exception;

}
