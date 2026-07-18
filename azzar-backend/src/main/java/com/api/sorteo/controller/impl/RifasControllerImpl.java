package com.api.sorteo.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.api.sorteo.beans.Rifas;
import com.api.sorteo.controller.RifasController;
import com.api.sorteo.service.RifasService;

@Component
public class RifasControllerImpl implements RifasController {

    @Autowired
    private RifasService rifasService;

    @Override
    public ResponseEntity<List<Rifas>> traerRifas() {
        return ResponseEntity.ok(rifasService.traerRifas());
    }

    @Override
    public ResponseEntity<Rifas> traerRifaPorId(Integer idRifa) {
        return ResponseEntity.ok(rifasService.traerRifaPorId(idRifa));
    }

    @Override
    public ResponseEntity<List<Rifas>> traerRifasPorPremio(Integer idPremio) {
        return ResponseEntity.ok(rifasService.traerRifasPorPremio(idPremio));
    }

    @Override
    public ResponseEntity<Boolean> crearRifas(Integer idPremio, Integer cantidad) {
        return ResponseEntity.ok(rifasService.crearRifas(idPremio, cantidad));
    }

    @Override
    public ResponseEntity<Boolean> editarRifa(Integer idRifa, Rifas rifa) {
        return ResponseEntity.ok(rifasService.editarRifa(idRifa, rifa));
    }

    @Override
    public ResponseEntity<Boolean> eliminarRifaPorId(Integer idRifa) {
        return ResponseEntity.ok(rifasService.eliminarRifaPorId(idRifa));
    }
}
