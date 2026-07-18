package com.api.sorteo.dao;

import java.util.List;

import com.api.sorteo.beans.LogsResponse;

public interface TotalesDAO {
    Integer traerVentasTotales(Integer idEmpresa);
    Integer traerEventosActivos(Integer idEmpresa);
    Integer traerPremiosDisponibles(Integer idEmpresa);
    Integer traerClientesActivos(Integer idEmpresa);
    List<LogsResponse> traerLogs();
}
