package com.examen.demo.service;

import com.examen.demo.entity.EstadoPedido;
import com.examen.demo.entity.PedidoEntity;
import com.examen.demo.entity.PersonaEntity;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    PedidoEntity crearPedido(PedidoEntity pedido, Long personaId);
    List<PedidoEntity> buscarTodos();
    Optional<PedidoEntity> buscarPedidoPorParametro(Long id, EstadoPedido estado);
    PedidoEntity actualizarPedido(PedidoEntity pedido);
    void eliminarPedido(Long id);
}
