package com.alkemy.gestordealumnos.controller;

import com.alkemy.gestordealumnos.entities.CourseEntity;
import com.alkemy.gestordealumnos.exceptions.NotFoundException;
import com.alkemy.gestordealumnos.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    @Autowired
    public CourseService courseService;

    @GetMapping
    public List<CourseEntity> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CourseEntity> getById(@PathVariable int id) throws Exception {
        return courseService.getById(id);
    }

    @PostMapping("/add")
    public List<CourseEntity> saveCourse(@RequestBody CourseEntity course) {
        return courseService.saveCourse(course);
    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFoundedException(NotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        return errorResponse;
    }


}
