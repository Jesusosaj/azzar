package com.api.sorteo.dao.impl;

import com.api.sorteo.beans.EmpresasAfiliadas;
import com.api.sorteo.dao.EmpresasAfiliadasDAO;
import com.api.sorteo.mapper.EmpresasAfiliadasMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpresasAfiliadasDAOImpl implements EmpresasAfiliadasDAO {

    private static final String SELECT_ALL =
            "SELECT * FROM EMPRESAS_AFILIADAS";

    private static final String SELECT_BY_ID =
            "SELECT * FROM EMPRESAS_AFILIADAS WHERE ID_EMPRESA = ?";

    private static final String INSERT =
            "INSERT INTO EMPRESAS_AFILIADAS (NOMBRE_EMPRESA, FECHA_DESDE_ALQUILER, FECHA_HASTA_ALQUILER) VALUES (?, ?, ?)";

    private static final String UPDATE =
            "UPDATE EMPRESAS_AFILIADAS SET NOMBRE_EMPRESA=?, FECHA_DESDE_ALQUILER=?, FECHA_HASTA_ALQUILER=? WHERE ID_EMPRESA=?";

    private static final String DELETE =
            "DELETE FROM EMPRESAS_AFILIADAS WHERE ID_EMPRESA=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<EmpresasAfiliadas> traerEmpresasAfiliadas() {
        return jdbcTemplate.query(SELECT_ALL, new EmpresasAfiliadasMapper());
    }

    @Override
    public EmpresasAfiliadas traerEmpresaAfiliadaPorId(Integer idEmpresa) {
        try {
            return jdbcTemplate.queryForObject(
                    SELECT_BY_ID,
                    new EmpresasAfiliadasMapper(),
                    idEmpresa
            );
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public Boolean crearEmpresaAfiliada(EmpresasAfiliadas empresa) {
        int rows = jdbcTemplate.update(
                INSERT,
                empresa.getNombreEmpresa(),
                empresa.getFechaDesdeAlquiler(),
                empresa.getFechaHastaAlquiler()
        );

        return rows > 0;
    }

    @Override
    public Boolean editarEmpresaAfiliada(Integer idEmpresa, EmpresasAfiliadas empresa) {
        int rows = jdbcTemplate.update(
                UPDATE,
                empresa.getNombreEmpresa(),
                empresa.getFechaDesdeAlquiler(),
                empresa.getFechaHastaAlquiler(),
                idEmpresa
        );

        return rows > 0;
    }

    @Override
    public Boolean eliminarEmpresaAfiliadaPorId(Integer idEmpresa) {
        return jdbcTemplate.update(DELETE, idEmpresa) > 0;
    }
}
