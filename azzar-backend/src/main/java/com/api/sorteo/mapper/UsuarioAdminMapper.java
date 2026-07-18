package com.api.sorteo.mapper;

import com.api.sorteo.beans.UsuarioAdmin;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioAdminMapper implements RowMapper<UsuarioAdmin> {
    @Override
    public UsuarioAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsuarioAdmin u = new UsuarioAdmin();
        u.setIdUsuario(rs.getInt("ID_USUARIO"));
        u.setIdEmpresa(rs.getInt("ID_EMPRESA"));
        u.setUsuario(rs.getString("USUARIO"));
        u.setContrasena(rs.getString("CONTRASENA"));
        u.setFechaRegistro(rs.getString("FECHA_REGISTRO"));
        return u;
    }
}
