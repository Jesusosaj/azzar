package com.api.sorteo.service;

import com.api.sorteo.beans.Pedidos;
import java.util.List;

public interface PedidosService {
    List<Pedidos> obtenerPedidosPendientesPorCliente(int idCliente);
}
