package com.alkemy.gestordealumnos.controller;


import com.alkemy.gestordealumnos.entities.CourseEntity;
import com.alkemy.gestordealumnos.entities.StudentEntity;
import com.alkemy.gestordealumnos.exceptions.NotFoundException;
import com.alkemy.gestordealumnos.service.CourseService;
import com.alkemy.gestordealumnos.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/students")
public class StudentController {


    @Autowired
    public StudentService studentService;

    @Autowired
    private CourseService courseService;


    @GetMapping
    public List<StudentEntity> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")

    public Optional<StudentEntity> getById(@PathVariable int id) throws Exception {
        return studentService.getById(id);
    }


    @PostMapping("/{studentId}/add-course/{courseId}")
    public ResponseEntity<StudentEntity> addCourseToStudent(
            @PathVariable int studentId,
            @PathVariable int courseId
    ) {
        StudentEntity student = studentService.addCourseToStudent(studentId, courseId);
        return ResponseEntity.ok(student);
    }


    @PostMapping("/add")
    public List<StudentEntity> addStudent(@RequestBody StudentEntity student, HttpServletRequest request) {

        if (student.getCourse() == null) {
            student.setCourse(new ArrayList<>());
        }

        return studentService.saveStudent(student);
    }


    @DeleteMapping("/{id}")
    public List<StudentEntity> deleteByPosition(@PathVariable int id) {
        return studentService.delete(id);
    }

    @DeleteMapping("/{studentId}/delete-course/{courseId}")
    public List<StudentEntity> deleteCourseFromStudent(
            @PathVariable int studentId,
            @PathVariable int courseId
    ) {

        return studentService.deleteCourseFromStudent(studentId, courseId);
    }

    @PutMapping("/{id}")

    public List<StudentEntity> update(@PathVariable int id, @RequestBody StudentEntity student) throws Exception {
        return studentService.update(id, student);
    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNoEncontradoException(NotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("mensaje", ex.getMessage());
        return errorResponse;
    }


}



