package com.api.sorteo.controller.impl;

import com.api.sorteo.beans.Ventas;
import com.api.sorteo.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VentasControllerImpl {

    @Autowired
    private VentasService ventasService;

    public List<Ventas> obtenerReporteGeneral() {
        return ventasService.obtenerReporteGeneral();
    }

    public List<Ventas> obtenerReportePorEmpresa(Integer idEmpresa) {
        return ventasService.obtenerReportePorEmpresa(idEmpresa);
    }
    
    public List<Ventas> obtenerReportePorPremio(Integer idPremio) {
        return ventasService.obtenerReportePorPremio(idPremio);
    }
}
