package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Pelicula")
@Getter
@Setter
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String titulo;

    @Column(name = "fecha_estreno")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaEstreno;

    private Integer calificacion;

    // Para la relación N-M de Películas con Personajes
    @ManyToMany(fetch = FetchType.EAGER,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
    @JoinTable(name = "Pelicula_Personaje",
            joinColumns = { @JoinColumn(name = "pelicula_id") },
            inverseJoinColumns = { @JoinColumn(name = "personaje_id") })
    private Set<PersonajeEntity> personajes;

    // Para la relación 1-N de Películas con Género
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id", insertable = false, updatable = false)
    private GeneroEntity genero;

    @Column(name = "genero_id", nullable = false)
    private Long generoId;
}
