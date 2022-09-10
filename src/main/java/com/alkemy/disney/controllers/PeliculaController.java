package com.alkemy.disney.controllers;

import com.alkemy.disney.dtos.PeliculaDTO;
import com.alkemy.disney.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("peliculas")
public class PeliculaController {
    
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<PeliculaDTO>> getAll() {
        List<PeliculaDTO> peliculas = peliculaService.getAllPeliculas();

        return ResponseEntity.ok().body(peliculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> getById(@PathVariable Long id) {
        PeliculaDTO pelicula = peliculaService.getPelicula(id);

        return ResponseEntity.ok().body(pelicula);
    }

    @PostMapping
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO pelicula) {
        PeliculaDTO peliculaGuardada = peliculaService.save(pelicula);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        peliculaService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
