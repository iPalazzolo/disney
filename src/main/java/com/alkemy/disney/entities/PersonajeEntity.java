package com.alkemy.disney.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Personaje")
@Getter
@Setter
public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private Integer edad;

    private Double peso;

    private String historia;

    @ManyToMany(fetch = FetchType.EAGER,
        cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        },
        mappedBy = "personajes")
    private Set<PeliculaEntity> peliculas;
}
