package com.alkemy.gestordealumnos.entities;
import com.alkemy.gestordealumnos.exceptions.validationMessage.ValidateMessage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message="{ValidateMessage.NOT_NULL_NAME}")
    private String name;
    private String lastName;

    @Min(value = 18, message = "{ValidateMessage.AGE_MIN_BE}" + " {value}")
    @Max(value = 99, message = "{ValidateMessage.AGE_MAM_BE}" + " {value}")
    private int age;


    private int rating;
    private boolean coursePending;
    private LocalDate date_entry;
    private boolean paid;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)

    private List<CourseEntity> course = new ArrayList<>();


    public StudentEntity() {

    }
}
