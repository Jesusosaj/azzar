package com.api.sorteo.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.api.sorteo.beans.Premios;
import com.api.sorteo.controller.PremiosController;
import com.api.sorteo.service.PremiosService;

@Component
public class PremiosControllerImpl implements PremiosController {

    @Autowired
    private PremiosService premiosService;

    @Override
    public ResponseEntity<List<Premios>> traerPremios() {
        return ResponseEntity.ok(premiosService.traerPremios());
    }

    @Override
    public ResponseEntity<Premios> traerPremioPorId(Integer idPremio) {
        return ResponseEntity.ok(premiosService.traerPremioPorId(idPremio));
    }

    @Override
    public ResponseEntity<List<Premios>> traerPremiosPorEvento(Integer idEvento) {
        return ResponseEntity.ok(premiosService.traerPremiosPorEvento(idEvento));
    }

    @Override
    public ResponseEntity<Boolean> crearPremio(Premios premio) {
        return ResponseEntity.ok(premiosService.crearPremio(premio));
    }

    @Override
    public ResponseEntity<Boolean> editarPremio(Integer idPremio, Premios premio) {
        return ResponseEntity.ok(premiosService.editarPremio(idPremio, premio));
    }

    @Override
    public ResponseEntity<Boolean> eliminarPremioPorId(Integer idPremio) {
        return ResponseEntity.ok(premiosService.eliminarPremioPorId(idPremio));
    }
}
