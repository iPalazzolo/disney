package com.alkemy.disney.mappers;

import com.alkemy.disney.dtos.PeliculaDTO;
import com.alkemy.disney.entities.PeliculaEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaMapper {

    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto) {
        PeliculaEntity entity = new PeliculaEntity();

        entity.setImagen(dto.getImagen());
        entity.setTitulo(dto.getTitulo());
        entity.setFechaEstreno(dto.getFechaEstreno());
        entity.setCalificacion(dto.getCalificacion());
        entity.setGeneroId(dto.getGeneroId());
        return entity;
    }

    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity) {
        PeliculaDTO dto = new PeliculaDTO();

        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setTitulo(entity.getTitulo());
        dto.setFechaEstreno(entity.getFechaEstreno());
        dto.setCalificacion(entity.getCalificacion());
        dto.setGeneroId(entity.getGeneroId());
        return dto;
    }

    public List<PeliculaDTO> peliculaEntityList2DTO(List<PeliculaEntity> entityList) {
        List<PeliculaDTO> dtoList = new ArrayList<>();

        for(PeliculaEntity entity: entityList)
            dtoList.add(peliculaEntity2DTO(entity));

        return dtoList;
    }
}
