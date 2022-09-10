package com.alkemy.disney.services.impl;

import com.alkemy.disney.dtos.PersonajeDTO;
import com.alkemy.disney.entities.PersonajeEntity;
import com.alkemy.disney.mappers.PersonajeMapper;
import com.alkemy.disney.repositories.PersonajeRepository;
import com.alkemy.disney.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private PersonajeRepository personajeRepository;

    public PersonajeDTO save(PersonajeDTO dto) {
        PersonajeEntity entity = personajeMapper.personajeDTO2Entity(dto);
        PersonajeEntity personajeSaved = personajeRepository.save(entity);

        return personajeMapper.personajeEntity2DTO(personajeSaved);
    }

    public List<PersonajeDTO> getAllPersonajes() {
        List<PersonajeEntity> entities = personajeRepository.findAll();

        return personajeMapper.personajeEntityList2DTO(entities);
    }

    public PersonajeDTO getPersonaje(Long id) {
        Optional<PersonajeEntity> entity = personajeRepository.findById(id);

        if(entity.isPresent())
            return personajeMapper.personajeEntity2DTO(entity.get());

        throw new RuntimeException("Personaje no encontrado...");
    }

    public void delete(Long id) {
        personajeRepository.deleteById(id);
    }
}
