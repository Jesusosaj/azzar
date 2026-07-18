package com.api.sorteo.controller;

import com.api.sorteo.beans.Rifas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/azzar/rifas")
public class RifasControllerDecorator implements RifasController {

    private final RifasController delegate;

    public RifasControllerDecorator(RifasController delegate) {
        this.delegate = delegate;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Rifas>> traerRifas() {
        return delegate.traerRifas();
    }

    @GetMapping("/{idRifa}")
    @Override
    public ResponseEntity<Rifas> traerRifaPorId(@PathVariable Integer idRifa) {
        return delegate.traerRifaPorId(idRifa);
    }

    @GetMapping("/premio/{idPremio}")
    @Override
    public ResponseEntity<List<Rifas>> traerRifasPorPremio(@PathVariable Integer idPremio) {
        return delegate.traerRifasPorPremio(idPremio);
    }

    @PostMapping("/registrar")
    @Override
    public ResponseEntity<Boolean> crearRifas(@RequestParam Integer idPremio, @RequestParam Integer cantidad) {
        return delegate.crearRifas(idPremio, cantidad);
    }

    @PutMapping("/{idRifa}")
    @Override
    public ResponseEntity<Boolean> editarRifa(@PathVariable Integer idRifa, @RequestBody Rifas rifa) {
        return delegate.editarRifa(idRifa, rifa);
    }

    @DeleteMapping("/{idRifa}")
    @Override
    public ResponseEntity<Boolean> eliminarRifaPorId(@PathVariable Integer idRifa) {
        return delegate.eliminarRifaPorId(idRifa);
    }
}
