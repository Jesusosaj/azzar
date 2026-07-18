package com.api.sorteo.mapper;

import com.api.sorteo.beans.Agente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AgenteMapper implements RowMapper<Agente> {

    @Override
    public Agente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Agente agente = new Agente();
        agente.setIdRifa(rs.getInt("ID_RIFA"));
        agente.setNumeroRifa(rs.getString("NUMERO_RIFA"));
        agente.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
        agente.setSexo(rs.getString("SEXO"));
        return agente;
    }
}
