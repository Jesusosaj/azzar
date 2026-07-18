package com.api.sorteo.controller.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.api.sorteo.beans.LogsResponse;
import com.api.sorteo.beans.TotalesResponse;
import com.api.sorteo.controller.TotalesController;
import com.api.sorteo.service.TotalesService;

@Component
public class TotalesControllerImpl implements TotalesController{
	 @Autowired
	    private TotalesService totalesService;

	    @Override
	    public ResponseEntity<TotalesResponse> obtenerTotales(Integer idEmpresa) {
	    	 return ResponseEntity.ok(totalesService.obtenerTotales(idEmpresa));
	    }
	    
	    @Override
	    public ResponseEntity<List<LogsResponse>> traerLogs() {
	        List<LogsResponse> logs = totalesService.traerLogs();
	        return ResponseEntity.ok(logs);
	    }
}
