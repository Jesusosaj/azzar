package com.api.sorteo.mapper;

import com.api.sorteo.beans.EmpresasAfiliadas;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresasAfiliadasMapper implements RowMapper<EmpresasAfiliadas> {

    @Override
    public EmpresasAfiliadas mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmpresasAfiliadas e = new EmpresasAfiliadas();
        e.setIdEmpresa(rs.getInt("ID_EMPRESA"));
        e.setNombreEmpresa(rs.getString("NOMBRE_EMPRESA"));
        e.setFechaDesdeAlquiler(rs.getTimestamp("FECHA_DESDE_ALQUILER"));
        e.setFechaHastaAlquiler(rs.getTimestamp("FECHA_HASTA_ALQUILER"));
        e.setFechaRegistro(rs.getTimestamp("FECHA_REGISTRO"));
        return e;
    }
}
