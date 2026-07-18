package com.api.sorteo.service.impl;

import com.api.sorteo.beans.LogsResponse;
import com.api.sorteo.beans.TotalesResponse;
import com.api.sorteo.dao.TotalesDAO;
import com.api.sorteo.service.TotalesService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TotalesServiceImpl implements TotalesService {

    private final TotalesDAO totalesDAO;

    public TotalesServiceImpl(TotalesDAO totalesDAO) {
        this.totalesDAO = totalesDAO;
    }

    @Override
    public TotalesResponse obtenerTotales(Integer idEmpresa) {
        TotalesResponse response = new TotalesResponse();
        response.setTotalVentas(totalesDAO.traerVentasTotales(idEmpresa));
        response.setTotalEventos(totalesDAO.traerEventosActivos(idEmpresa));
        response.setTotalPremios(totalesDAO.traerPremiosDisponibles(idEmpresa));
        response.setTotalUsuarios(totalesDAO.traerClientesActivos(idEmpresa));
        return response;
    }
    
    @Override
    public List<LogsResponse> traerLogs() {
        return totalesDAO.traerLogs();
    }
}
