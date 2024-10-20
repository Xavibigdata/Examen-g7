package com.examen.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="persona")
@Getter
@Setter

public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String apellidos;
    private String numeroDocumento;

    @Enumerated(EnumType.STRING)
    private EstadoPersona estado; // ACTIVO, INACTIVO

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DireccionEntity> direcciones;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PedidoEntity> pedidos;
}
