package com.examen.demo.service.impl;

import com.examen.demo.entity.EstadoPersona;
import com.examen.demo.entity.PersonaEntity;
import com.examen.demo.repository.PersonaRepository;
import com.examen.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public PersonaEntity crearPersona(PersonaEntity persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<PersonaEntity> buscarTodos() {
        return personaRepository.findByEstado(EstadoPersona.ACTIVO);
    }

    @Override
    public Optional<PersonaEntity> buscarPersonaXnumDocumento(String numeroDocumento) {
        return personaRepository.findByNumeroDocumento(numeroDocumento);
    }

    @Override
    public PersonaEntity actualizarPersona(PersonaEntity persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void eliminarPersona(Long id) {
        PersonaEntity persona = personaRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        persona.setEstado(EstadoPersona.INACTIVO);
        personaRepository.save(persona);
    }
}
