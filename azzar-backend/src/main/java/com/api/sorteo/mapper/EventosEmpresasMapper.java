package com.api.sorteo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.springframework.jdbc.core.RowMapper;
import com.api.sorteo.beans.EventosEmpresas;

public class EventosEmpresasMapper implements RowMapper<EventosEmpresas> {

    @Override
    public EventosEmpresas mapRow(ResultSet rs, int rowNum) throws SQLException {

        EventosEmpresas evento = new EventosEmpresas();

        evento.setIdEvento(rs.getInt("ID_EVENTO"));
        evento.setIdEmpresa(rs.getInt("ID_EMPRESA"));
        evento.setNombreEvento(rs.getString("NOMBRE_EVENTO"));
        evento.setUbicacionEvento(rs.getString("UBICACION_EVENTO"));

        evento.setImagenFlyer(rs.getString("IMAGEN_FLYER"));

        evento.setFechaRegistro(rs.getTimestamp("FECHA_REGISTRO"));

        return evento;
    }
}
