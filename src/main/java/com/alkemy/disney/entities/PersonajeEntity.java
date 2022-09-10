package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Personaje")
@SQLDelete(sql = "UPDATE personaje SET deleted=true WHERE id=?")
@Where(clause = "deleted=false")
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

    private boolean deleted = Boolean.FALSE;
}
