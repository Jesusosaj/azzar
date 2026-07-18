package com.api.sorteo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.api.sorteo.beans.Rifas;

public class RifasMapper implements RowMapper<Rifas> {

    @Override
    public Rifas mapRow(ResultSet rs, int rowNum) throws SQLException {
        Rifas rifa = new Rifas();
        rifa.setIdRifa(rs.getInt("ID_RIFA"));
        rifa.setIdPremio(rs.getInt("ID_PREMIO"));
        rifa.setNumeroRifa(rs.getString("NUMERO_RIFA"));
        rifa.setEstadoRifa(rs.getInt("ESTADO_RIFA"));
        rifa.setFechaCreacion(rs.getTimestamp("FECHA_CREACION"));
        return rifa;
    }
}
