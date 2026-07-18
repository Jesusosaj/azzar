package com.api.sorteo.controller;

import com.api.sorteo.beans.EventosEmpresas;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/v1/azzar/eventos")
public class EventosEmpresasControllerDecorator implements EventosEmpresasController {

    private final EventosEmpresasController delegate;

    public EventosEmpresasControllerDecorator(EventosEmpresasController delegate) {
        this.delegate = delegate;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<EventosEmpresas>> traerEventos() {
        return delegate.traerEventos();
    }

    @GetMapping("/{idEvento}")
    @Override
    public ResponseEntity<EventosEmpresas> traerEventoPorId(@PathVariable Integer idEvento) {
        return delegate.traerEventoPorId(idEvento);
    }

    @GetMapping("/empresa/{idEmpresa}")
    @Override
    public ResponseEntity<List<EventosEmpresas>> traerEventosPorEmpresa(@PathVariable Integer idEmpresa) {
        return delegate.traerEventosPorEmpresa(idEmpresa);
    }

    @PostMapping(value = "/registrar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<Boolean> crearEvento(@ModelAttribute EventosEmpresas evento) {
        try {
            if (evento.getImagenFlyerFile() != null && !evento.getImagenFlyerFile().isEmpty()) {
                byte[] bytes = evento.getImagenFlyerFile().getBytes();
                String base64 = Base64.getEncoder().encodeToString(bytes);
                evento.setImagenFlyer(base64);
            }
            return delegate.crearEvento(evento);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(false);
        }
    }

    @PutMapping(value = "/{idEvento}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<Boolean> editarEvento(
            @PathVariable Integer idEvento,
            @ModelAttribute EventosEmpresas evento
    ) {
        try {
        	ResponseEntity<EventosEmpresas> response = delegate.traerEventoPorId(idEvento);
        	EventosEmpresas eventoActual = response.getBody();
        	
            if (eventoActual == null) {
                return ResponseEntity.notFound().build();
            }

            if (evento.getImagenFlyerFile() != null && !evento.getImagenFlyerFile().isEmpty()) {
                byte[] bytes = evento.getImagenFlyerFile().getBytes();
                String base64 = Base64.getEncoder().encodeToString(bytes);
                evento.setImagenFlyer(base64);
            } else {
                evento.setImagenFlyer(eventoActual.getImagenFlyer());
            }

            evento.setIdEvento(idEvento);
            return delegate.editarEvento(idEvento, evento);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(false);
        }
    }


    @DeleteMapping("/{idEvento}")
    @Override
    public ResponseEntity<Boolean> eliminarEventoPorId(@PathVariable Integer idEvento) {
        return delegate.eliminarEventoPorId(idEvento);
    }
}
