package com.api.sorteo.service;

import java.util.List;

import com.api.sorteo.beans.LogsResponse;
import com.api.sorteo.beans.TotalesResponse;

public interface TotalesService {
    TotalesResponse obtenerTotales(Integer idEmpresa);
    List<LogsResponse> traerLogs();
}
