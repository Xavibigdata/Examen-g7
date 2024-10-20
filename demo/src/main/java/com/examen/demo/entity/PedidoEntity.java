package com.examen.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedido")
@Getter
@Setter
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private int cantidad;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado; // PENDIENTE, PROCESO, CONFIRMADO, ELIMINADO
}
