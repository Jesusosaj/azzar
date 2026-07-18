package com.api.sorteo.dao.impl;

import com.api.sorteo.beans.Clientes;
import com.api.sorteo.dao.ClientesDAO;
import com.api.sorteo.mapper.ClientsMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class ClientesDAOImpl implements ClientesDAO {

    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final String TRAER_CLIENTES =
            "SELECT * FROM CLIENTES";

    private static final String TRAER_CLIENTE_POR_ID =
            "SELECT * FROM CLIENTES WHERE ID_CLIENTE = ?";

    private static final String TRAER_CLIENTE_POR_CORREO =
            "SELECT * FROM CLIENTES WHERE CORREO = ?";

    private static final String EDITAR_CLIENTE =
            "UPDATE CLIENTES SET NOMBRE_CLIENTE = ?, SEXO = ?, NRO_DOCUMENTO = ?, CORREO = ?, CONTRASENA = ?, TELEFONO = ?, ESTADO = ? WHERE ID_CLIENTE = ?";

    private static final String ELIMINAR_CLIENTE =
            "DELETE FROM CLIENTES WHERE ID_CLIENTE = ?";

    @Autowired
    public ClientesDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Clientes> traerClientes() {
        return jdbcTemplate.query(TRAER_CLIENTES, new ClientsMapper());
    }

    @Override
    public Clientes traerClientePorId(Integer idCliente) {
        try {
            return jdbcTemplate.queryForObject(TRAER_CLIENTE_POR_ID, new ClientsMapper(), idCliente);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public Clientes traerClientePorCorreo(String correo) {
        try {
            return jdbcTemplate.queryForObject(TRAER_CLIENTE_POR_CORREO, new ClientsMapper(), correo);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public Boolean crearCliente(Clientes cliente) {

        String sql = """
            INSERT INTO CLIENTES 
            (NOMBRE_CLIENTE, SEXO, NRO_DOCUMENTO, CORREO, CONTRASENA, TELEFONO, ESTADO)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        int rows = jdbcTemplate.update(sql,
                cliente.getNombreCliente(),
                cliente.getSexo(),
                cliente.getNroDocumento(),
                cliente.getCorreo(),
                passwordEncoder.encode(cliente.getContrasena()),
                cliente.getTelefono(),
                cliente.getEstado()
        );

        return rows > 0;
    }

    @Override
    public Boolean editarCliente(Integer idCliente, Clientes cliente) {
        return jdbcTemplate.update(
                EDITAR_CLIENTE,
                cliente.getNombreCliente(),
                cliente.getSexo(),
                cliente.getNroDocumento(),
                cliente.getCorreo(),
                passwordEncoder.encode(cliente.getContrasena()),
                cliente.getTelefono(),
                cliente.getEstado(),
                idCliente
        ) > 0;
    }

    @Override
    public Boolean eliminarClientePorId(Integer idCliente) {
        return jdbcTemplate.update(ELIMINAR_CLIENTE, idCliente) > 0;
    }

    @Override
    public Boolean actualizarContrasena(Integer idCliente, String nuevaContrasena) {
        return jdbcTemplate.update(
                "UPDATE CLIENTES SET CONTRASENA = ? WHERE ID_CLIENTE = ?",
                nuevaContrasena,
                idCliente
        ) > 0;
    }
}
