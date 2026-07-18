package com.api.sorteo.service;

import com.api.sorteo.beans.Agente;

import java.util.List;

public interface AgenteService {
    List<Agente> traerParticipantesPorPremio(Integer idPremio);
    String traerNombrePremio(Integer idPremio);
    Agente realizarSorteoPorPremio(Integer idPremio, Boolean agenteHabilitado) throws Exception;
}
