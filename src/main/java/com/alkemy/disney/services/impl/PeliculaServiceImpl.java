package com.alkemy.disney.services.impl;

import com.alkemy.disney.dtos.PeliculaDTO;
import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.mappers.PeliculaMapper;
import com.alkemy.disney.repositories.PeliculaRepository;
import com.alkemy.disney.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaMapper peliculaMapper;
    @Autowired
    private PeliculaRepository peliculaRepository;

    public PeliculaDTO save(PeliculaDTO dto) {
        PeliculaEntity entity = peliculaMapper.peliculaDTO2Entity(dto);
        PeliculaEntity peliculaSaved = peliculaRepository.save(entity);
        PeliculaDTO result = peliculaMapper.peliculaEntity2DTO(peliculaSaved);

        return result;
    }
}
