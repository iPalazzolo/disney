package com.alkemy.disney.mappers;

import com.alkemy.disney.dtos.PersonajeDTO;
import com.alkemy.disney.entities.PersonajeEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonajeMapper {

    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto) {
        PersonajeEntity entity = new PersonajeEntity();

        entity.setNombre(dto.getNombre());
        entity.setEdad(dto.getEdad());
        entity.setPeso(dto.getPeso());
        entity.setHistoria(dto.getHistoria());
        entity.setPeliculas(dto.getPeliculas());
        return entity;
    }

    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity) {
        PersonajeDTO dto = new PersonajeDTO();

        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        dto.setHistoria(entity.getHistoria());
        dto.setPeliculas(entity.getPeliculas());
        return dto;
    }
}
