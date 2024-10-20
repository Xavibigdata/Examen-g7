package com.examen.demo.repository;

import com.examen.demo.entity.EstadoPersona;
import com.examen.demo.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
    Optional<PersonaEntity> findByNumeroDocumento(String numeroDocumento);
    List<PersonaEntity> findByEstado(EstadoPersona estado);

}
