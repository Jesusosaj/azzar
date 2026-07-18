package com.api.sorteo.dao;

import java.util.List;
import com.api.sorteo.beans.Premios;

public interface PremiosDAO {

    List<Premios> traerPremios();

    Premios traerPremioPorId(Integer idPremio);

    List<Premios> traerPremiosPorEvento(Integer idEvento);

    Boolean crearPremio(Premios premio);

    Boolean editarPremio(Integer idPremio, Premios premio);

    Boolean eliminarPremioPorId(Integer idPremio);
}
