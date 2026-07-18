package com.api.sorteo.service;

import com.api.sorteo.beans.Ventas;
import java.util.List;

public interface VentasService {
    List<Ventas> obtenerReporteGeneral();
    List<Ventas> obtenerReportePorEmpresa(Integer idEmpresa);
    List<Ventas> obtenerReportePorPremio(Integer idPremio);
}
