package com.alkemy.gestordealumnos.service.Impl;

import com.alkemy.gestordealumnos.entities.CourseEntity;
import com.alkemy.gestordealumnos.repository.CourseRepository;
import com.alkemy.gestordealumnos.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl  implements CourseService {


    @Autowired
    public CourseRepository courseRepository;

    @Override
    public List<CourseEntity> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<CourseEntity> getById(int id) throws Exception {

        return courseRepository.findById(id);
    }

    @Override
    public List<CourseEntity> saveCourse(CourseEntity course) {

            courseRepository.save(course);
            return getAll();
    }


    @Override
    public List<CourseEntity> delete(int id) {
        return null;
    }

    @Override
    public List<CourseEntity> update(int id, CourseEntity course) throws Exception {
        return null;
    }
}
