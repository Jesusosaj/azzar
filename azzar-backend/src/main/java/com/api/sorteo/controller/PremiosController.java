package com.api.sorteo.controller;

import com.api.sorteo.beans.Premios;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface PremiosController {

    ResponseEntity<List<Premios>> traerPremios();

    ResponseEntity<Premios> traerPremioPorId(Integer idPremio);

    ResponseEntity<List<Premios>> traerPremiosPorEvento(Integer idEvento);

    ResponseEntity<Boolean> crearPremio(Premios premio);

    ResponseEntity<Boolean> editarPremio(Integer idPremio, Premios premio);

    ResponseEntity<Boolean> eliminarPremioPorId(Integer idPremio);
}
