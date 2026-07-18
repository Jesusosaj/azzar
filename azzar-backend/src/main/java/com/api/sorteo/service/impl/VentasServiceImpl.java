package com.api.sorteo.service.impl;

import com.api.sorteo.beans.Ventas;
import com.api.sorteo.dao.VentasDAO;
import com.api.sorteo.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImpl implements VentasService {

    @Autowired
    private VentasDAO ventasDAO;

    @Override
    public List<Ventas> obtenerReporteGeneral() {
        return ventasDAO.obtenerReporteGeneral();
    }

    @Override
    public List<Ventas> obtenerReportePorEmpresa(Integer idEmpresa) {
        return ventasDAO.obtenerReportePorEmpresa(idEmpresa);
    }
    
    @Override
    public List<Ventas> obtenerReportePorPremio(Integer idPremio) {
        return ventasDAO.obtenerReportePorPremio(idPremio);
    }
}
