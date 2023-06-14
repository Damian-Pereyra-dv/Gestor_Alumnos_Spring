package com.alkemy.gestordealumnos.service.Impl;
import com.alkemy.gestordealumnos.entities.CourseEntity;
import com.alkemy.gestordealumnos.entities.StudentEntity;
import com.alkemy.gestordealumnos.exceptions.NotFoundException;
import com.alkemy.gestordealumnos.exceptions.errorMenssage.ErrorMessage;
import com.alkemy.gestordealumnos.repository.CourseRepository;
import com.alkemy.gestordealumnos.repository.StudentRepository;
import com.alkemy.gestordealumnos.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentRepository studentRepository;
    @Autowired
    public CourseRepository courseRepository;


    @Override
    public List<StudentEntity> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<StudentEntity> getById(int id) throws Exception {

        return studentRepository.findById(id);
    }

    @Override
    public List<StudentEntity> saveStudent(StudentEntity student) {
        studentRepository.save(student);
        return getAll();
    }

    @Override
    public List<StudentEntity> delete(int id) {

        studentRepository.deleteById(id);
        return getAll();
    }

    @Override
    public List<StudentEntity> update(int id, StudentEntity student) throws Exception {
        return null;
    }
     @Override
    public StudentEntity addCourseToStudent(int studentId, int courseId) {
         StudentEntity  student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new NotFoundException(ErrorMessage.COURSE_NOT_FOUNDED));

         CourseEntity course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new NotFoundException(ErrorMessage.COURSE_NOT_FOUNDED));

            if (!student.getCourse().contains(course)) {
                student.getCourse().add(course);
                course.getStudents().add(student);
            }

            studentRepository.save(student);
            courseRepository.save(course);

            return student;
        }

    public List<StudentEntity> deleteCourseFromStudent(int studentId, int courseId) {
        // Obtener el estudiante por su ID
        StudentEntity student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            // Manejar el caso cuando el estudiante no existe
            throw new IllegalArgumentException("Estudiante no encontrado");
        }

        // Obtener el curso por su ID
        CourseEntity course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            // Manejar el caso cuando el curso no existe
            throw new IllegalArgumentException("Curso no encontrado");
        }

        // Verificar si el curso está presente en la lista del estudiante
        if (student.getCourse().contains(course)) {
            // Eliminar el curso de la lista del estudiante y viceversa
            student.getCourse().remove(course);
            course.getStudents().remove(student);
        }

        // Guardar los cambios en la base de datos
        studentRepository.save(student);
        courseRepository.save(course);

        // Devolver la lista actualizada de estudiantes
        return getAll();
    }



}