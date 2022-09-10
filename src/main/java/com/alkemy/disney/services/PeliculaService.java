package com.alkemy.disney.services;

import com.alkemy.disney.dtos.PeliculaDTO;

import java.util.List;

public interface PeliculaService {

    List<PeliculaDTO> getAllPeliculas();
    PeliculaDTO getPelicula(Long id);
    PeliculaDTO save(PeliculaDTO dto);
    void delete(Long id);
}
