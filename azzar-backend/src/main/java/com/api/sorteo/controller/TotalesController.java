package com.api.sorteo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.sorteo.beans.LogsResponse;
import com.api.sorteo.beans.TotalesResponse;

public interface TotalesController {
    ResponseEntity<TotalesResponse> obtenerTotales(Integer idEmpresa);
    ResponseEntity<List<LogsResponse>> traerLogs();
}
