package com.api.sorteo.controller;

import com.api.sorteo.beans.Rifas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

public interface RifasController {

    ResponseEntity<List<Rifas>> traerRifas();

    ResponseEntity<Rifas> traerRifaPorId(Integer idRifa);

    ResponseEntity<List<Rifas>> traerRifasPorPremio(Integer idPremio);

    ResponseEntity<Boolean> crearRifas(Integer idPremio,Integer cantidad);

    ResponseEntity<Boolean> editarRifa(Integer idRifa, Rifas rifa);

    ResponseEntity<Boolean> eliminarRifaPorId(Integer idRifa);
}
