package com.alkemy.disney.services.impl;

import com.alkemy.disney.dtos.PersonajeDTO;
import com.alkemy.disney.entities.PersonajeEntity;
import com.alkemy.disney.mappers.PersonajeMapper;
import com.alkemy.disney.repositories.PersonajeRepository;
import com.alkemy.disney.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private PersonajeRepository personajeRepository;

    public PersonajeDTO save(PersonajeDTO dto) {
        PersonajeEntity entity = personajeMapper.personajeDTO2Entity(dto);
        PersonajeEntity personajeSaved = personajeRepository.save(entity);
        PersonajeDTO result = personajeMapper.personajeEntity2DTO(personajeSaved);

        return result;
    }
}
