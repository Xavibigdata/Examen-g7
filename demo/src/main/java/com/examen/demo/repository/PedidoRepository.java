package com.examen.demo.repository;

import com.examen.demo.entity.EstadoPedido;
import com.examen.demo.entity.PedidoEntity;
import com.examen.demo.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity,Long> {
    List<PedidoEntity> findByEstado(EstadoPedido estado);

}
