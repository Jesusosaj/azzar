package com.api.sorteo.controller.impl;

import com.api.sorteo.beans.Agente;
import com.api.sorteo.controller.AgenteController;
import com.api.sorteo.service.AgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class AgenteControllerImpl implements AgenteController {

    @Autowired
    private AgenteService agenteService;

    @Override
    public List<Agente> traerParticipantesPorPremio(Integer idPremio) {
        return agenteService.traerParticipantesPorPremio(idPremio);
    }

    public Agente realizarSorteoPorPremio(Integer idPremio, Boolean agenteHabilitado) throws Exception {
        return agenteService.realizarSorteoPorPremio(idPremio, agenteHabilitado);
    }
}
