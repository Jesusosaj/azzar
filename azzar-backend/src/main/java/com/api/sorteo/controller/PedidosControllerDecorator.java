package com.api.sorteo.controller;

import com.api.sorteo.beans.Pedidos;
import org.springframework.http.ResponseEntity;
import java.util.List;

public abstract class PedidosControllerDecorator {

    public ResponseEntity<List<Pedidos>> obtenerPedidosPendientesPorCliente(int idCliente) {
        return ResponseEntity.badRequest().build();
    }
}
