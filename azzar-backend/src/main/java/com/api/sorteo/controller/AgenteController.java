package com.api.sorteo.controller;

import com.api.sorteo.beans.Agente;

import java.util.List;

public interface AgenteController {
    List<Agente> traerParticipantesPorPremio(Integer idPremio);
    Agente realizarSorteoPorPremio(Integer idPremio, Boolean agenteHabilitado) throws Exception;
}
