package com.api.sorteo.dao;

import com.api.sorteo.beans.Agente;
import java.util.List;

public interface AgenteDAO {
    List<Agente> traerParticipantesPorPremio(Integer idPremio);
    String traerNombrePremio(Integer idPremio);
}
