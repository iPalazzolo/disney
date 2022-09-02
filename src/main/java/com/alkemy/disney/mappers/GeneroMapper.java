package com.alkemy.disney.mappers;

import com.alkemy.disney.dtos.GeneroDTO;
import com.alkemy.disney.entities.GeneroEntity;
import org.springframework.stereotype.Service;

@Service
public class GeneroMapper {

    public GeneroEntity generoDTO2Entity(GeneroDTO dto) {
        GeneroEntity entity = new GeneroEntity();

        entity.setNombre(dto.getNombre());
        entity.setImagen(dto.getImagen());
        return entity;
    }

    public GeneroDTO generoEntity2DTO(GeneroEntity entity) {
        GeneroDTO dto = new GeneroDTO();

        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setImagen(entity.getImagen());
        return dto;
    }
}
