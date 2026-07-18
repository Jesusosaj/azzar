package com.api.sorteo.mapper;

import com.api.sorteo.beans.Pedidos;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidosMapper implements RowMapper<Pedidos> {
    @Override
    public Pedidos mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pedidos pedido = new Pedidos();
        pedido.setNumeroRifa(rs.getString("NUMERO_RIFA"));
        pedido.setPrecioRifa(rs.getDouble("PRECIO_RIFA"));
        pedido.setNombrePremio(rs.getString("NOMBRE_PREMIO"));
        pedido.setIdRifa(rs.getInt("ID_RIFA"));
        pedido.setIdVenta(rs.getInt("ID_VENTA"));
        return pedido;
    }
}
