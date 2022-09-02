package com.alkemy.disney.services.impl;

import com.alkemy.disney.dtos.GeneroDTO;
import com.alkemy.disney.entities.GeneroEntity;
import com.alkemy.disney.mappers.GeneroMapper;
import com.alkemy.disney.repositories.GeneroRepository;
import com.alkemy.disney.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroMapper generoMapper;
    @Autowired
    private GeneroRepository generoRepository;

    public GeneroDTO save(GeneroDTO dto) {
        GeneroEntity entity = generoMapper.generoDTO2Entity(dto);
        GeneroEntity generoSaved = generoRepository.save(entity);
        GeneroDTO result = generoMapper.generoEntity2DTO(generoSaved);

        return result;
    }
}
