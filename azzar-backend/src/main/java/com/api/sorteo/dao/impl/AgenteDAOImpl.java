package com.api.sorteo.dao.impl;

import com.api.sorteo.dao.AgenteDAO;
import com.api.sorteo.beans.Agente;
import com.api.sorteo.mapper.AgenteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgenteDAOImpl implements AgenteDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AgenteDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Agente> traerParticipantesPorPremio(Integer idPremio) {
        String sql = "SELECT R.ID_RIFA, R.NUMERO_RIFA, C.NOMBRE_CLIENTE, C.SEXO " +
                     "FROM VENTAS V " +
                     "INNER JOIN RIFAS R ON V.ID_RIFA = R.ID_RIFA " +
                     "INNER JOIN CLIENTES C ON V.ID_CLIENTE = C.ID_CLIENTE " +
                     "WHERE R.ID_PREMIO = ? AND V.ESTADO_VENTA = 2";
        return jdbcTemplate.query(sql, new AgenteMapper(), idPremio);
    }
    
    @Override
    public String traerNombrePremio(Integer idPremio) {
        String sql = "SELECT R.NOMBRE_PREMIO FROM PREMIOS R WHERE R.ID_PREMIO = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{idPremio}, String.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
