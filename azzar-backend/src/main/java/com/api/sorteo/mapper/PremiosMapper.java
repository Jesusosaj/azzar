package com.api.sorteo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.springframework.jdbc.core.RowMapper;
import com.api.sorteo.beans.Premios;

public class PremiosMapper implements RowMapper<Premios> {

    @Override
    public Premios mapRow(ResultSet rs, int rowNum) throws SQLException {
        Premios premio = new Premios();

        premio.setIdPremio(rs.getInt("ID_PREMIO"));
        premio.setIdEvento(rs.getInt("ID_EVENTO"));
        premio.setNombrePremio(rs.getString("NOMBRE_PREMIO"));
        premio.setDescripcion(rs.getString("DESCRIPCION"));

        // IMAGEN como BLOB → convertir a Base64
        premio.setImagen(rs.getString("IMAGEN"));

        premio.setPrecioRifa(rs.getBigDecimal("PRECIO_RIFA"));
        premio.setEstado(rs.getInt("ESTADO"));
        premio.setFechaSorteo(rs.getTimestamp("FECHA_SORTEO"));
        premio.setFechaCreacion(rs.getTimestamp("FECHA_CREACION"));

        return premio;
    }
}
