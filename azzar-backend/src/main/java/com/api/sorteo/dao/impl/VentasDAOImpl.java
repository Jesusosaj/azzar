package com.api.sorteo.dao.impl;

import com.api.sorteo.beans.Ventas;
import com.api.sorteo.dao.VentasDAO;
import com.api.sorteo.mapper.VentasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VentasDAOImpl implements VentasDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Ventas> obtenerReporteGeneral() {
        String sql = "SELECT * FROM VW_REPORTE_GENERAL_VENTAS";
        return jdbcTemplate.query(sql, new VentasMapper());
    }

    @Override
    public List<Ventas> obtenerReportePorEmpresa(Integer idEmpresa) {
        String sql = "SELECT * FROM VW_REPORTE_GENERAL_VENTAS WHERE ID_EMPRESA = ?";
        return jdbcTemplate.query(sql, new Object[]{idEmpresa}, new VentasMapper());
    }
    
    @Override
    public List<Ventas> obtenerReportePorPremio(Integer idPremio) {
        String sql = "SELECT * FROM VW_REPORTE_GENERAL_VENTAS WHERE ID_PREMIO = ?";
        return jdbcTemplate.query(sql, new Object[]{idPremio}, new VentasMapper());
    }
}
