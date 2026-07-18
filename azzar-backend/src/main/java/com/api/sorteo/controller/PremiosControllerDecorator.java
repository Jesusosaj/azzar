package com.api.sorteo.controller;

import com.api.sorteo.beans.EventosEmpresas;
import com.api.sorteo.beans.Premios;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/v1/azzar/premios")
public class PremiosControllerDecorator implements PremiosController {

    private final PremiosController delegate;

    public PremiosControllerDecorator(PremiosController delegate) {
        this.delegate = delegate;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Premios>> traerPremios() {
        return delegate.traerPremios();
    }

    @GetMapping("/{idPremio}")
    @Override
    public ResponseEntity<Premios> traerPremioPorId(@PathVariable Integer idPremio) {
        return delegate.traerPremioPorId(idPremio);
    }

    @GetMapping("/evento/{idEvento}")
    @Override
    public ResponseEntity<List<Premios>> traerPremiosPorEvento(@PathVariable Integer idEvento) {
        return delegate.traerPremiosPorEvento(idEvento);
    }

    @PostMapping(value = "/registrar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<Boolean> crearPremio(@ModelAttribute Premios premio) {
    	try {
            if (premio.getImagenPremio() != null && !premio.getImagenPremio().isEmpty()) {
                byte[] bytes = premio.getImagenPremio().getBytes();
                String base64 = Base64.getEncoder().encodeToString(bytes);
                premio.setImagen(base64);
            }
            return delegate.crearPremio(premio);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(false);
        }
    }

    @PutMapping(value = "/{idPremio}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<Boolean> editarPremio(@PathVariable Integer idPremio, @ModelAttribute Premios premio) {
    	ResponseEntity<Premios> response = delegate.traerPremioPorId(idPremio);
    	Premios premios = response.getBody();
    	
        if (premio == null) {
            return ResponseEntity.notFound().build();
        }
        
    	try {
            if (premio.getImagenPremio() != null && !premio.getImagenPremio().isEmpty()) {
                byte[] bytes = premio.getImagenPremio().getBytes();
                String base64 = Base64.getEncoder().encodeToString(bytes);
                premio.setImagen(base64);
            }else {
            	premio.setImagen(premios.getImagen());
            }
            
            return delegate.editarPremio(idPremio, premio);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(false);
        }
    	
    }

    @DeleteMapping("/{idPremio}")
    @Override
    public ResponseEntity<Boolean> eliminarPremioPorId(@PathVariable Integer idPremio) {
        return delegate.eliminarPremioPorId(idPremio);
    }
}
