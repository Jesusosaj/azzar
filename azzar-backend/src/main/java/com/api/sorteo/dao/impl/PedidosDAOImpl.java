package com.api.sorteo.dao.impl;

import com.api.sorteo.dao.PedidosDAO;
import com.api.sorteo.mapper.PedidosMapper;
import com.api.sorteo.beans.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidosDAOImpl implements PedidosDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Pedidos> obtenerPedidosPendientesPorCliente(int idCliente) {
        String sql = """
            SELECT R.NUMERO_RIFA, P.PRECIO_RIFA, P.NOMBRE_PREMIO, R.ID_RIFA, V.ID_VENTA
            FROM VENTAS V 
            INNER JOIN RIFAS R ON V.ID_RIFA = R.ID_RIFA
            INNER JOIN PREMIOS P ON R.ID_PREMIO = P.ID_PREMIO
            WHERE V.ESTADO_VENTA = 1 
              AND R.ESTADO_RIFA = 3 
              AND P.ESTADO = 1 
              AND V.ID_CLIENTE = ?
        """;

        return jdbcTemplate.query(sql, new PedidosMapper(), idCliente);
    }
}
