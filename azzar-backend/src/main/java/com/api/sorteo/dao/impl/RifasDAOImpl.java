package com.api.sorteo.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.sorteo.beans.Rifas;
import com.api.sorteo.dao.RifasDAO;
import com.api.sorteo.mapper.RifasMapper;

@Repository
public class RifasDAOImpl implements RifasDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final String TRAER_RIFAS =
            "SELECT * FROM RIFAS";

    private static final String TRAER_RIFA_POR_ID =
            "SELECT * FROM RIFAS WHERE ID_RIFA = ?";

    private static final String TRAER_RIFAS_POR_PREMIO =
            "SELECT * FROM RIFAS WHERE ID_PREMIO = ?";

    private static final String CREAR_RIFA =
            "INSERT INTO RIFAS (ID_PREMIO, NUMERO_RIFA, ESTADO_RIFA) VALUES (?, ?, ?)";

    private static final String EDITAR_RIFA =
            "UPDATE RIFAS SET ID_PREMIO = ?, NUMERO_RIFA = ?, ESTADO_RIFA = ? WHERE ID_RIFA = ?";

    private static final String ELIMINAR_RIFA =
            "DELETE FROM RIFAS WHERE ID_RIFA = ?";

    @Autowired
    public RifasDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Rifas> traerRifas() {
        return jdbcTemplate.query(TRAER_RIFAS, new RifasMapper());
    }

    @Override
    public Rifas traerRifaPorId(Integer idRifa) {
    	try {
            return jdbcTemplate.queryForObject(
                TRAER_RIFA_POR_ID,
                new RifasMapper(),
                idRifa
            );
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Rifas> traerRifasPorPremio(Integer idPremio) {
        return jdbcTemplate.query(TRAER_RIFAS_POR_PREMIO, new RifasMapper(), idPremio);
    }
    
    @Override
    public Boolean crearRifas(Integer idPremio, Integer cantidad) {
        for (int i = 1; i <= cantidad; i++) {
            String numeroRifa = String.format("%04d", i); // Formato: 0001, 0002...
            jdbcTemplate.update(CREAR_RIFA, idPremio, numeroRifa, 1); // 1 = DISPONIBLE
        }
        return true;
    }

    @Override
    public Boolean editarRifa(Integer idRifa, Rifas rifa) {
        int rows = jdbcTemplate.update(
            EDITAR_RIFA,
            rifa.getIdPremio(),
            rifa.getNumeroRifa(),
            rifa.getEstadoRifa(),
            idRifa
        );
        return rows > 0;
    }

    @Override
    public Boolean eliminarRifaPorId(Integer idRifa) {
        int rows = jdbcTemplate.update(ELIMINAR_RIFA, idRifa);
        return rows > 0;
    }
}
