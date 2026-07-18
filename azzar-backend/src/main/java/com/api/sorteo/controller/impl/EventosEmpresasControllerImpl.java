package com.api.sorteo.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.api.sorteo.beans.EventosEmpresas;
import com.api.sorteo.controller.EventosEmpresasController;
import com.api.sorteo.service.EventosEmpresasService;

@Component
public class EventosEmpresasControllerImpl implements EventosEmpresasController {

    @Autowired
    private EventosEmpresasService eventosEmpresasService;

    @Override
    public ResponseEntity<List<EventosEmpresas>> traerEventos() {
        return ResponseEntity.ok(eventosEmpresasService.traerEventos());
    }

    @Override
    public ResponseEntity<EventosEmpresas> traerEventoPorId(Integer idEvento) {
        return ResponseEntity.ok(eventosEmpresasService.traerEventoPorId(idEvento));
    }

    @Override
    public ResponseEntity<List<EventosEmpresas>> traerEventosPorEmpresa(Integer idEmpresa) {
        return ResponseEntity.ok(eventosEmpresasService.traerEventosPorEmpresa(idEmpresa));
    }

    @Override
    public ResponseEntity<Boolean> crearEvento(EventosEmpresas evento) {
        return ResponseEntity.ok(eventosEmpresasService.crearEvento(evento));
    }

    @Override
    public ResponseEntity<Boolean> editarEvento(Integer idEvento, EventosEmpresas evento) {
        return ResponseEntity.ok(eventosEmpresasService.editarEvento(idEvento, evento));
    }

    @Override
    public ResponseEntity<Boolean> eliminarEventoPorId(Integer idEvento) {
        return ResponseEntity.ok(eventosEmpresasService.eliminarEventoPorId(idEvento));
    }
}
