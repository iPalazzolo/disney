package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Genero")
@Getter
@Setter
public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String imagen;

    /*
    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Set<PeliculaEntity> peliculas;
     */
}
