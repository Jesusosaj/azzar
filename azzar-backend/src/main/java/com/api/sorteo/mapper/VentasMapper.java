package com.api.sorteo.mapper;

import com.api.sorteo.beans.Ventas;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class VentasMapper implements RowMapper<Ventas> {

    @Override
    public Ventas mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ventas v = new Ventas();

        v.setIdVenta(rs.getInt("ID_VENTA"));
        v.setIdPremio(rs.getInt("ID_PREMIO"));
        v.setNombreEmpresa(rs.getString("NOMBRE_EMPRESA"));
        v.setNombreEvento(rs.getString("NOMBRE_EVENTO"));
        v.setNombrePremio(rs.getString("NOMBRE_PREMIO"));
        v.setNumeroRifa(rs.getString("NUMERO_RIFA"));
        v.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
        v.setSexo(rs.getString("SEXO"));
        v.setEstadoVenta(rs.getInt("ESTADO_VENTA"));
        v.setPrecioRifa(rs.getDouble("PRECIO_RIFA"));

        // Manejo seguro de fechas
        Timestamp ts = rs.getTimestamp("FECHA_VENTA");
        if (ts != null) {
            v.setFechaVenta(ts.toLocalDateTime());
        }

        return v;
    }
}
