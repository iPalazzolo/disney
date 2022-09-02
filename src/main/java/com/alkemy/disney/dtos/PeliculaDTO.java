package com.alkemy.disney.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PeliculaDTO {
    private Long id;
    private String imagen;
    private String titulo;
    private LocalDate fechaEstreno;
    private Double calificacion;
    private Long generoId;
}
