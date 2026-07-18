package com.api.sorteo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.api.sorteo.beans.ItemsPago;

public class ItemsPagoMapper implements RowMapper<ItemsPago> {

    @Override
    public ItemsPago mapRow(ResultSet rs, int rowNum) throws SQLException {
        ItemsPago item = new ItemsPago();
        item.setIdVenta(rs.getInt("ID_VENTA"));
        item.setNumeroRifa(rs.getString("NUMERO_RIFA"));
        item.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
        item.setNombrePremio(rs.getString("NOMBRE_PREMIO"));
        item.setNombreEvento(rs.getString("NOMBRE_EVENTO"));
        item.setNombreEmpresa(rs.getString("NOMBRE_EMPRESA"));
        item.setEstadoVenta(rs.getInt("ESTADO_VENTA"));
        item.setFechaVenta(rs.getTimestamp("FECHA_VENTA"));
        item.setPrecioRifa(rs.getDouble("PRECIO_RIFA"));
        return item;
    }
}
