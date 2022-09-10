package com.alkemy.disney.services.impl;

import com.alkemy.disney.dtos.PeliculaDTO;
import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.mappers.PeliculaMapper;
import com.alkemy.disney.repositories.PeliculaRepository;
import com.alkemy.disney.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaMapper peliculaMapper;
    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<PeliculaDTO> getAllPeliculas() {
        List<PeliculaEntity> entities = peliculaRepository.findAll();

        return peliculaMapper.peliculaEntityList2DTO(entities);
    }

    public PeliculaDTO getPelicula(Long id) {
        Optional<PeliculaEntity> entity = peliculaRepository.findById(id);

        if(entity.isPresent())
            return peliculaMapper.peliculaEntity2DTO(entity.get());

        throw new RuntimeException("Película no encontrada...");
    }

    public PeliculaDTO save(PeliculaDTO dto) {
        PeliculaEntity entity = peliculaMapper.peliculaDTO2Entity(dto);
        PeliculaEntity peliculaSaved = peliculaRepository.save(entity);

        return peliculaMapper.peliculaEntity2DTO(peliculaSaved);
    }

    public void delete(Long id) {
        peliculaRepository.deleteById(id);
    }
}
