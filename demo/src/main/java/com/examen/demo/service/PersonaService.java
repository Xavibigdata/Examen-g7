package com.examen.demo.service;

import com.examen.demo.entity.PersonaEntity;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    PersonaEntity crearPersona(PersonaEntity persona);
    List<PersonaEntity> buscarTodos();
    Optional<PersonaEntity> buscarPersonaXnumDocumento(String numeroDocumento);
    PersonaEntity actualizarPersona(PersonaEntity persona);
    void eliminarPersona(Long id);
}
