package com.alkemy.disney.services;

import com.alkemy.disney.dtos.PersonajeDTO;

import java.util.List;

public interface PersonajeService {

    List<PersonajeDTO> getAllPersonajes();
    PersonajeDTO getPersonaje(Long id);
    PersonajeDTO save(PersonajeDTO dto);
    void delete(Long id);
}
