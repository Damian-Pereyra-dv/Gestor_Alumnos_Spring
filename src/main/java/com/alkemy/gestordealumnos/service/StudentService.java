package com.alkemy.gestordealumnos.service;


import com.alkemy.gestordealumnos.entities.StudentEntity;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    List<StudentEntity> getAll();

    Optional<StudentEntity> getById(int id) throws Exception;

    List<StudentEntity> saveStudent(StudentEntity a);

    List<StudentEntity> delete(int id);

    List<StudentEntity> update(int id, StudentEntity student) throws Exception;

    StudentEntity addCourseToStudent(int studentId, int courseId);

    List<StudentEntity> deleteCourseFromStudent(int studentId, int courseId);
}


