package com.api.sorteo.dao.impl;

import com.api.sorteo.beans.LogsResponse;
import com.api.sorteo.dao.TotalesDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TotalesDAOImpl implements TotalesDAO {

    private final JdbcTemplate jdbcTemplate;

    public TotalesDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer traerVentasTotales(Integer idEmpresa) {
        String sql = "SELECT TraerVentasTotales(?) FROM dual";
        return jdbcTemplate.queryForObject(sql, Integer.class, idEmpresa);
    }

    @Override
    public Integer traerEventosActivos(Integer idEmpresa) {
        String sql = "SELECT TraerEventosActivos(?) FROM dual";
        return jdbcTemplate.queryForObject(sql, Integer.class, idEmpresa);
    }

    @Override
    public Integer traerPremiosDisponibles(Integer idEmpresa) {
        String sql = "SELECT TraerPremiosDisponibles(?) FROM dual";
        return jdbcTemplate.queryForObject(sql, Integer.class, idEmpresa);
    }

    @Override
    public Integer traerClientesActivos(Integer idEmpresa) {
        String sql = "SELECT TraerClientesActivos(?) FROM dual";
        return jdbcTemplate.queryForObject(sql, Integer.class, idEmpresa);
    }
    
    @Override
    public List<LogsResponse> traerLogs() {
        String sql = "SELECT ID_LOG, NOMBRE_CLIENTE, DESCRIPCION_ACCION, DETALLE, FECHA_HORA " +
                     "FROM LOGS ORDER BY FECHA_HORA DESC";

        return jdbcTemplate.query(sql, (rs, rowNum) -> mapRow(rs));
    }
    
    private LogsResponse mapRow(ResultSet rs) throws SQLException {
        LogsResponse log = new LogsResponse();
        log.setIdLog(rs.getInt("ID_LOG"));
        log.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
        log.setDescripcionAccion(rs.getString("DESCRIPCION_ACCION"));
        log.setDetalle(rs.getString("DETALLE"));
        log.setFechaHora(rs.getString("FECHA_HORA"));
        return log;
    }
}
