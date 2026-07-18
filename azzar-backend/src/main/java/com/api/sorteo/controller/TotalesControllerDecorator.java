package com.api.sorteo.controller;

import com.api.sorteo.beans.LogsResponse;
import com.api.sorteo.beans.TotalesResponse;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/azzar")
public class TotalesControllerDecorator implements TotalesController {

    private final TotalesController delegate;

    public TotalesControllerDecorator(TotalesController delegate) {
        this.delegate = delegate;
    }

    @GetMapping("/totales")
    @Override
    public ResponseEntity<TotalesResponse> obtenerTotales(@RequestParam(required = false) Integer idEmpresa) {
        TotalesResponse response = delegate.obtenerTotales(idEmpresa).getBody();

        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/logs")
    @Override
    public ResponseEntity<List<LogsResponse>> traerLogs() {
        return delegate.traerLogs();
    }
}
