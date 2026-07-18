package com.api.sorteo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.api.sorteo.beans.Clientes;

public class ClientsMapper implements RowMapper<Clientes> {

    @Override
    public Clientes mapRow(ResultSet rs, int rowNum) throws SQLException {
        Clientes cliente = new Clientes();
        cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
        cliente.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
        cliente.setSexo(rs.getString("SEXO"));
        cliente.setNroDocumento(rs.getString("NRO_DOCUMENTO"));
        cliente.setCorreo(rs.getString("CORREO"));
        cliente.setContrasena(rs.getString("CONTRASENA"));
        cliente.setTelefono(rs.getString("TELEFONO"));
        cliente.setEstado(rs.getInt("ESTADO"));
        cliente.setFechaRegistro(rs.getTimestamp("FECHA_REGISTRO"));
        
        return cliente;
    }
}
