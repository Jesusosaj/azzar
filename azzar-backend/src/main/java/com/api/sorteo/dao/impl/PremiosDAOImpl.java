package com.api.sorteo.dao.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.sorteo.beans.Premios;
import com.api.sorteo.dao.PremiosDAO;
import com.api.sorteo.mapper.PremiosMapper;

@Repository
public class PremiosDAOImpl implements PremiosDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final String TRAER_PREMIOS = "SELECT * FROM PREMIOS";
    private static final String TRAER_PREMIO_POR_ID = "SELECT * FROM PREMIOS WHERE ID_PREMIO = ?";
    private static final String TRAER_PREMIOS_POR_EVENTO = "SELECT * FROM PREMIOS WHERE ID_EVENTO = ?";
    private static final String CREAR_PREMIO = 
        "INSERT INTO PREMIOS (ID_EVENTO, NOMBRE_PREMIO, DESCRIPCION, IMAGEN, PRECIO_RIFA, ESTADO, FECHA_SORTEO) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String EDITAR_PREMIO = 
        "UPDATE PREMIOS SET ID_EVENTO = ?, NOMBRE_PREMIO = ?, DESCRIPCION = ?, IMAGEN = ?, PRECIO_RIFA = ?, ESTADO = ?, FECHA_SORTEO = ? " +
        "WHERE ID_PREMIO = ?";
    private static final String ELIMINAR_PREMIO = "DELETE FROM PREMIOS WHERE ID_PREMIO = ?";

    @Autowired
    public PremiosDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Premios> traerPremios() {
        return jdbcTemplate.query(TRAER_PREMIOS, new PremiosMapper());
    }

    @Override
    public Premios traerPremioPorId(Integer idPremio) {
        try {
            return jdbcTemplate.queryForObject(
                TRAER_PREMIO_POR_ID,
                new PremiosMapper(),
                idPremio
            );
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Premios> traerPremiosPorEvento(Integer idEvento) {
        return jdbcTemplate.query(TRAER_PREMIOS_POR_EVENTO, new PremiosMapper(), idEvento);
    }

    @Override
    public Boolean crearPremio(Premios premio) {

        String imagenClob = null;
        if (premio.getImagen() != null) {
            imagenClob = premio.getImagen();  // base64 como STRING (CLOB)
        }

        int rows = jdbcTemplate.update(
            CREAR_PREMIO,
            premio.getIdEvento(),
            premio.getNombrePremio(),
            premio.getDescripcion(),
            imagenClob,
            premio.getPrecioRifa(),
            premio.getEstado(),
            premio.getFechaSorteo()
        );

        return rows > 0;
    }

    @Override
    public Boolean editarPremio(Integer idPremio, Premios premio) {

        String imagenClob = null;
        if (premio.getImagen() != null) {
            imagenClob = premio.getImagen();  // sigue siendo base64 como STRING
        }

        int rows = jdbcTemplate.update(
            EDITAR_PREMIO,
            premio.getIdEvento(),
            premio.getNombrePremio(),
            premio.getDescripcion(),
            imagenClob,
            premio.getPrecioRifa(),
            premio.getEstado(),
            premio.getFechaSorteo(),
            idPremio
        );

        return rows > 0;
    }

    @Override
    public Boolean eliminarPremioPorId(Integer idPremio) {
        int rows = jdbcTemplate.update(ELIMINAR_PREMIO, idPremio);
        return rows > 0;
    }
}
