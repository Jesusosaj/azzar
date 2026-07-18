package com.api.sorteo.controller;

import com.api.sorteo.beans.Agente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/azzar/agente")
public class AgenteControllerDecorator implements AgenteController {

    private final AgenteController agenteControllerImpl;

    public AgenteControllerDecorator(AgenteController agenteControllerImpl) {
        this.agenteControllerImpl = agenteControllerImpl;
    }

    @GetMapping("/participantes/{idPremio}")
    @Override
    public List<Agente> traerParticipantesPorPremio(@PathVariable Integer idPremio) {
        return agenteControllerImpl.traerParticipantesPorPremio(idPremio);
    }

    @PostMapping("/sorteo/{idPremio}")
    @Override
    public Agente realizarSorteoPorPremio(@PathVariable Integer idPremio,
                                          @RequestHeader Boolean agenteHabilitado) throws Exception {
        return agenteControllerImpl.realizarSorteoPorPremio(idPremio, agenteHabilitado);
    }
}
