package com.alkemy.gestordealumnos.repository;

import com.alkemy.gestordealumnos.entities.StudentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {





}



