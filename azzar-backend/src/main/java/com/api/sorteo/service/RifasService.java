package com.api.sorteo.service;

import java.util.List;
import com.api.sorteo.beans.Rifas;

public interface RifasService {

    List<Rifas> traerRifas();

    Rifas traerRifaPorId(Integer idRifa);

    List<Rifas> traerRifasPorPremio(Integer idPremio);

    Boolean crearRifas(Integer idPremio, Integer cantidad);

    Boolean editarRifa(Integer idRifa, Rifas rifa);

    Boolean eliminarRifaPorId(Integer idRifa);
}
