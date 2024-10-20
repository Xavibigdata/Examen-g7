package com.examen.demo.service.impl;

import com.examen.demo.entity.EstadoPedido;
import com.examen.demo.entity.PedidoEntity;
import com.examen.demo.entity.PersonaEntity;
import com.examen.demo.repository.PedidoRepository;
import com.examen.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements com.examen.demo.service.PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public PedidoEntity crearPedido(PedidoEntity pedido, Long personaId) {
        PersonaEntity persona = personaRepository.findById(personaId).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        persona.getPedidos().add(pedido);
        personaRepository.save(persona);
        return pedido;
    }

    @Override
    public List<PedidoEntity> buscarTodos() {
        return pedidoRepository.findByEstado(EstadoPedido.PENDIENTE);
    }

    @Override
    public Optional<PedidoEntity> buscarPedidoPorParametro(Long id, EstadoPedido estado) {
        return pedidoRepository.findById(id);
    }

    @Override
    public PedidoEntity actualizarPedido(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        PedidoEntity pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        pedido.setEstado(EstadoPedido.ELIMINADO);
        pedidoRepository.save(pedido);
    }
}
