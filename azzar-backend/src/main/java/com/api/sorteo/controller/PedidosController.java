package com.api.sorteo.controller;

import com.api.sorteo.beans.Pedidos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pedidos")
public interface PedidosController {

    @GetMapping("/pendientes/{idCliente}")
    ResponseEntity<List<Pedidos>> obtenerPedidosPendientesPorCliente(int idCliente);
}
