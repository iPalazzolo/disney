package com.alkemy.disney.dtos;

import com.alkemy.disney.entities.PeliculaEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PersonajeDTO {
    private Long id;
    private String nombre;
    private Integer edad;
    private Double peso;
    private String historia;
    private Set<PeliculaEntity> peliculas;
}
