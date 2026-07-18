package com.api.sorteo.service.impl;

import com.api.sorteo.dao.PedidosDAO;
import com.api.sorteo.beans.Pedidos;
import com.api.sorteo.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosServiceImpl implements PedidosService {

    @Autowired
    private PedidosDAO pedidosDAO;

    @Override
    public List<Pedidos> obtenerPedidosPendientesPorCliente(int idCliente) {
        return pedidosDAO.obtenerPedidosPendientesPorCliente(idCliente);
    }
}
