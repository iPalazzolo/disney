package com.alkemy.disney.services;

import com.alkemy.disney.dtos.GeneroDTO;

import java.util.List;

public interface GeneroService {

    List<GeneroDTO> getAllGeneros();
    GeneroDTO getGenero(Long id);
    GeneroDTO save(GeneroDTO dto);
    void delete(Long id);
}
