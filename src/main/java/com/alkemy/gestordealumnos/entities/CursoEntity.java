package com.alkemy.gestordealumnos.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class CursoEntity {

    private Long id;
    private String nombre;
    private String descripcion;
    private int duracion;


}
