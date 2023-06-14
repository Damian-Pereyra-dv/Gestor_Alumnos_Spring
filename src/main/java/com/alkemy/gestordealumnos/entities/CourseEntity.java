package com.alkemy.gestordealumnos.entities;

import com.alkemy.gestordealumnos.exceptions.validationMessage.ValidateMessage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message="{ValidateMessage.NOT_NULL_NAME}")
    private String name;
    @NotBlank(message = "{ValidateMessage.NOT_EMPTY_DESCRIPTION}")
    private String description;
    @Positive(message = "{ValidateMessage.NOT_NEGATIVE_NUMBER}")
    private int monthsDuration;

    @ManyToMany
    @JsonIgnore
    private List<StudentEntity> students = new ArrayList<>();


    public CourseEntity() {

    }
}
