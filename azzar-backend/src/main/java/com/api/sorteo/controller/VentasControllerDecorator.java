package com.api.sorteo.controller;

import com.api.sorteo.beans.Ventas;
import com.api.sorteo.controller.impl.VentasControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class VentasControllerDecorator {

    @Autowired
    private VentasControllerImpl ventasControllerImpl;

    @GetMapping("/reporte-general")
    public List<Ventas> obtenerReporteGeneral() {
        return ventasControllerImpl.obtenerReporteGeneral();
    }

    @GetMapping("/reporte-empresa/{idEmpresa}")
    public List<Ventas> obtenerReportePorEmpresa(@PathVariable Integer idEmpresa) {
        return ventasControllerImpl.obtenerReportePorEmpresa(idEmpresa);
    }
    
    @GetMapping("/reporte-por-premio/{idPremio}")
    public List<Ventas> obtenerReportePorPremio(@PathVariable Integer idPremio) {
        return ventasControllerImpl.obtenerReportePorPremio(idPremio);
    }
}
