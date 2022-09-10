package com.alkemy.disney.services.impl;

import com.alkemy.disney.dtos.GeneroDTO;
import com.alkemy.disney.entities.GeneroEntity;
import com.alkemy.disney.mappers.GeneroMapper;
import com.alkemy.disney.repositories.GeneroRepository;
import com.alkemy.disney.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroMapper generoMapper;
    @Autowired
    private GeneroRepository generoRepository;

    public List<GeneroDTO> getAllGeneros() {
        List<GeneroEntity> entities = generoRepository.findAll();

        return generoMapper.generoEntityList2DTO(entities);
    }

    public GeneroDTO getGenero(Long id) {
        Optional<GeneroEntity> entity = generoRepository.findById(id);

        if(entity.isPresent())
            return generoMapper.generoEntity2DTO(entity.get());

        throw new RuntimeException("Genero no encontrado...");
    }

    public GeneroDTO save(GeneroDTO dto) {
        GeneroEntity entity = generoMapper.generoDTO2Entity(dto);
        GeneroEntity generoSaved = generoRepository.save(entity);

        return generoMapper.generoEntity2DTO(generoSaved);
    }

    public void delete(Long id) {
        generoRepository.deleteById(id);
    }
}
