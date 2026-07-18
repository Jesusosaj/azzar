package com.api.sorteo.controller.impl;

import com.api.sorteo.controller.PedidosController;
import com.api.sorteo.beans.Pedidos;
import com.api.sorteo.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/azzar/pedidos")
public class PedidosControllerImpl implements PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @Override
    @GetMapping("/pendientes/{idCliente}")
    public ResponseEntity<List<Pedidos>> obtenerPedidosPendientesPorCliente(@PathVariable int idCliente) {
        List<Pedidos> pedidos = pedidosService.obtenerPedidosPendientesPorCliente(idCliente);
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }
}
