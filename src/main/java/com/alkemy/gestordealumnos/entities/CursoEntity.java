package com.alkemy.gestordealumnos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoEntity {

    private Long id;
    private String nombre;
    private String descripcion;
    private int duracion;
    private List<AlumnoEntity> alumnosAsociados;

}
