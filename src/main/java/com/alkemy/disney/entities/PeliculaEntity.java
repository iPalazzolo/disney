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

    @ManyToMany(fetch = FetchType.EAGER,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
    @JoinTable(name = "Pelicula_Personaje",
            joinColumns = { @JoinColumn(name = "pelicula_id") },
            inverseJoinColumns = { @JoinColumn(name = "personaje_id") })
    private Set<PersonajeEntity> personajes;

    @OneToMany(mappedBy = "peliculas", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GeneroEntity> generos;
}
