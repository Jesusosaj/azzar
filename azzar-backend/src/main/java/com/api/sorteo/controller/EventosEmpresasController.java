package com.api.sorteo.controller;

import com.api.sorteo.beans.EventosEmpresas;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface EventosEmpresasController {

    ResponseEntity<List<EventosEmpresas>> traerEventos();

    ResponseEntity<EventosEmpresas> traerEventoPorId(Integer idEvento);

    ResponseEntity<List<EventosEmpresas>> traerEventosPorEmpresa(Integer idEmpresa);

    ResponseEntity<Boolean> crearEvento(EventosEmpresas evento);

    ResponseEntity<Boolean> editarEvento(Integer idEvento, EventosEmpresas evento);

    ResponseEntity<Boolean> eliminarEventoPorId(Integer idEvento);
}
