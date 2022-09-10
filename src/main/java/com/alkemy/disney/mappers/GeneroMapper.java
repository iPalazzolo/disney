package com.alkemy.disney.mappers;

import com.alkemy.disney.dtos.GeneroDTO;
import com.alkemy.disney.entities.GeneroEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<GeneroDTO> generoEntityList2DTO(List<GeneroEntity> entityList) {
        List<GeneroDTO> dtoList = new ArrayList<>();

        for(GeneroEntity entity: entityList)
            dtoList.add(generoEntity2DTO(entity));

        return dtoList;
    }

    public List<GeneroEntity> generoDTOList2Entity(List<GeneroDTO> dtoList) {
        List<GeneroEntity> entityList = new ArrayList<>();

        for(GeneroDTO dto: dtoList)
            entityList.add(generoDTO2Entity(dto));

        return entityList;
    }
}
