package com.api.sorteo.dao.impl;

import com.api.sorteo.dao.UsuarioAdminDAO;
import com.api.sorteo.mapper.UsuarioAdminMapper;
import com.api.sorteo.beans.UsuarioAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioAdminDAOImpl implements UsuarioAdminDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UsuarioAdmin> obtenerUsuarios() {
        String sql = "SELECT * FROM USUARIOS_ADMIN";
        return jdbcTemplate.query(sql, new UsuarioAdminMapper());
    }

    @Override
    public Optional<UsuarioAdmin> obtenerUsuarioPorId(int idUsuario) {
        String sql = "SELECT * FROM USUARIOS_ADMIN WHERE ID_USUARIO = ?";
        List<UsuarioAdmin> lista = jdbcTemplate.query(sql, new UsuarioAdminMapper(), idUsuario);
        return lista.stream().findFirst();
    }
    
    @Override
    public Optional<UsuarioAdmin> obtenerUsuarioPorIdEmpresa(int idEmpresa) {
        String sql = "SELECT * FROM USUARIOS_ADMIN WHERE ID_EMPRESA = ?";
        List<UsuarioAdmin> lista = jdbcTemplate.query(sql, new UsuarioAdminMapper(), idEmpresa);
        return lista.stream().findFirst();
    }


    @Override
    public Optional<UsuarioAdmin> obtenerUsuarioPorNombre(String usuario) {
        String sql = "SELECT * FROM USUARIOS_ADMIN WHERE USUARIO = ?";
        List<UsuarioAdmin> lista = jdbcTemplate.query(sql, new UsuarioAdminMapper(), usuario);
        return lista.stream().findFirst();
    }

    @Override
    public int registrarUsuario(UsuarioAdmin usuarioAdmin) {
        String sql = "INSERT INTO USUARIOS_ADMIN (ID_EMPRESA, USUARIO, CONTRASENA) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, usuarioAdmin.getIdEmpresa(), usuarioAdmin.getUsuario(), usuarioAdmin.getContrasena());
    }

    @Override
    public int actualizarUsuario(UsuarioAdmin usuarioAdmin) {
        if (usuarioAdmin.getContrasena() == null || usuarioAdmin.getContrasena().trim().isEmpty()) {

            String sql = "UPDATE USUARIOS_ADMIN SET ID_EMPRESA = ?, USUARIO = ? WHERE ID_USUARIO = ?";

            return jdbcTemplate.update(
                sql,
                usuarioAdmin.getIdEmpresa(),
                usuarioAdmin.getUsuario(),
                usuarioAdmin.getIdUsuario()
            );
        }

        String sql = "UPDATE USUARIOS_ADMIN SET ID_EMPRESA = ?, USUARIO = ?, CONTRASENA = ? WHERE ID_USUARIO = ?";

        return jdbcTemplate.update(
            sql,
            usuarioAdmin.getIdEmpresa(),
            usuarioAdmin.getUsuario(),
            usuarioAdmin.getContrasena(),
            usuarioAdmin.getIdUsuario()
        );
    }


    @Override
    public int eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM USUARIOS_ADMIN WHERE ID_USUARIO = ?";
        return jdbcTemplate.update(sql, idUsuario);
    }
}
