package com.api.sorteo.dao;

import java.util.List;
import java.util.Optional;

import com.api.sorteo.beans.Rifas;

public interface RifasDAO {

    List<Rifas> traerRifas();

    Rifas traerRifaPorId(Integer idRifa);

    List<Rifas> traerRifasPorPremio(Integer idPremio);

    Boolean crearRifas(Integer idPremio, Integer cantidad);

    Boolean editarRifa(Integer idRifa, Rifas rifa);

    Boolean eliminarRifaPorId(Integer idRifa);
}
