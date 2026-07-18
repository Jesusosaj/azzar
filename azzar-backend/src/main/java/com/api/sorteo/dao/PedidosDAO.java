package com.api.sorteo.dao;

import com.api.sorteo.beans.Pedidos;
import java.util.List;

public interface PedidosDAO {
    List<Pedidos> obtenerPedidosPendientesPorCliente(int idCliente);
}
