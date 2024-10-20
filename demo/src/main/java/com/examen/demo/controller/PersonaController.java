package com.examen.demo.controller;

import com.examen.demo.entity.PersonaEntity;
import com.examen.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas/v1")

public class PersonaController {

    @Autowired
    private PersonaService personaService;
    @PostMapping("/crear")
    public ResponseEntity<PersonaEntity> crearPersona(@RequestBody PersonaEntity persona) {
        return new ResponseEntity<>(personaService.crearPersona(persona), HttpStatus.CREATED);
    }
    @GetMapping("/buscarTodos")
    public ResponseEntity<List<PersonaEntity>> buscarTodos() {
        return new ResponseEntity<>(personaService.buscarTodos(), HttpStatus.OK);
    }
    @GetMapping("/buscar/{numeroDocumento}")
    public ResponseEntity<Optional<PersonaEntity>> buscarPersonaXnumDocumento(@PathVariable String numeroDocumento) {
        return new ResponseEntity<>(personaService.buscarPersonaXnumDocumento(numeroDocumento), HttpStatus.OK);
    }
    @PutMapping("/actualizar")
    public ResponseEntity<PersonaEntity> actualizarPersona(@RequestBody PersonaEntity persona) {
        return new ResponseEntity<>(personaService.actualizarPersona(persona), HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
