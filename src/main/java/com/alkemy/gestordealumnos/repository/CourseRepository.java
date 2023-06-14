package com.alkemy.gestordealumnos.repository;

import com.alkemy.gestordealumnos.entities.StudentEntity;
import com.alkemy.gestordealumnos.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository <CourseEntity, Integer>{



}
