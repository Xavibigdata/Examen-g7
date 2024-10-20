package com.examen.demo.controller;

import com.examen.demo.entity.PedidoEntity;
import com.examen.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos/v1")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/crear/{personaId}")
    public ResponseEntity<PedidoEntity> crearPedido(@RequestBody PedidoEntity pedido, @PathVariable Long personaId) {
        return new ResponseEntity<>(pedidoService.crearPedido(pedido, personaId), HttpStatus.CREATED);
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<PedidoEntity>> buscarTodos() {
        return new ResponseEntity<>(pedidoService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<PedidoEntity>> buscarPedidoPorParametro(@PathVariable Long id) {
        return new ResponseEntity<>(pedidoService.buscarPedidoPorParametro(id, null), HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<PedidoEntity> actualizarPedido(@RequestBody PedidoEntity pedido) {
        return new ResponseEntity<>(pedidoService.actualizarPedido(pedido), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
