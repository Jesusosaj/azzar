package com.api.sorteo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.sorteo.beans.EventosEmpresas;
import com.api.sorteo.dao.EventosEmpresasDAO;
import com.api.sorteo.mapper.EventosEmpresasMapper;

@Repository
public class EventosEmpresasDAOImpl implements EventosEmpresasDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final String TRAER_EVENTOS = "SELECT * FROM EVENTOS_EMPRESA";
    private static final String TRAER_EVENTO_POR_ID = "SELECT * FROM EVENTOS_EMPRESA WHERE ID_EVENTO = ?";
    private static final String TRAER_EVENTOS_POR_EMPRESA = "SELECT * FROM EVENTOS_EMPRESA WHERE ID_EMPRESA = ?";
    private static final String CREAR_EVENTO = 
        "INSERT INTO EVENTOS_EMPRESA (ID_EMPRESA, NOMBRE_EVENTO, UBICACION_EVENTO, IMAGEN_FLYER) VALUES (?, ?, ?, ?)";
    private static final String EDITAR_EVENTO = 
        "UPDATE EVENTOS_EMPRESA SET ID_EMPRESA = ?, NOMBRE_EVENTO = ?, UBICACION_EVENTO = ?, IMAGEN_FLYER = ? WHERE ID_EVENTO = ?";
    private static final String ELIMINAR_EVENTO = "DELETE FROM EVENTOS_EMPRESA WHERE ID_EVENTO = ?";

    @Autowired
    public EventosEmpresasDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EventosEmpresas> traerEventos() {
        return jdbcTemplate.query(TRAER_EVENTOS, new EventosEmpresasMapper());
    }

    @Override
    public EventosEmpresas traerEventoPorId(Integer idEvento) {
        return jdbcTemplate.queryForObject(TRAER_EVENTO_POR_ID, new EventosEmpresasMapper(), idEvento);
    }

    @Override
    public List<EventosEmpresas> traerEventosPorEmpresa(Integer idEmpresa) {
        return jdbcTemplate.query(TRAER_EVENTOS_POR_EMPRESA, new EventosEmpresasMapper(), idEmpresa);
    }

    @Override
    public Boolean crearEvento(EventosEmpresas evento) {

        String imagenFlyer = evento.getImagenFlyer(); // Base64 como texto (CLOB)

        int rows = jdbcTemplate.update(
            CREAR_EVENTO,
            evento.getIdEmpresa(),
            evento.getNombreEvento(),
            evento.getUbicacionEvento(),
            imagenFlyer // CLOB correcto
        );

        return rows > 0;
    }

    @Override
    public Boolean editarEvento(Integer idEvento, EventosEmpresas evento) {

        String imagenFlyer = evento.getImagenFlyer(); // CLOB

        int rows = jdbcTemplate.update(
            EDITAR_EVENTO,
            evento.getIdEmpresa(),
            evento.getNombreEvento(),
            evento.getUbicacionEvento(),
            imagenFlyer,
            idEvento
        );

        return rows > 0;
    }

    @Override
    public Boolean eliminarEventoPorId(Integer idEvento) {
        int rows = jdbcTemplate.update(ELIMINAR_EVENTO, idEvento);
        return rows > 0;
    }
}
