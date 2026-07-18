package com.api.sorteo.service.impl;

import com.api.sorteo.beans.Agente;
import com.api.sorteo.dao.AgenteDAO;
import com.api.sorteo.service.AgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AgenteServiceImpl implements AgenteService {

    private static final String URL_SORTEO = "http://148.230.72.52:5000/sorteo";

    @Autowired
    private AgenteDAO agenteDAO;

    @Override
    public List<Agente> traerParticipantesPorPremio(Integer idPremio) {
        return agenteDAO.traerParticipantesPorPremio(idPremio);
    }
    
    @Override
    public String traerNombrePremio(Integer idPremio) {
        return agenteDAO.traerNombrePremio(idPremio);
    }

    @Override
    public Agente realizarSorteoPorPremio(Integer idPremio, Boolean agenteHabilitado) throws Exception {
        List<Agente> participantes = traerParticipantesPorPremio(idPremio);
        String nombrePremio = traerNombrePremio(idPremio);
        if(participantes.isEmpty()) throw new Exception("No hay participantes para este premio.");

        // Crear CSV en memoria
        String csv = "ID_RIFA,NUMERO_RIFA,NOMBRE_CLIENTE,SEXO\n" +
                participantes.stream()
                        .map(p -> p.getIdRifa() + "," + p.getNumeroRifa() + "," + p.getNombreCliente() + "," + p.getSexo())
                        .collect(Collectors.joining("\n"));

        ByteArrayResource resource = new ByteArrayResource(csv.getBytes()) {
            @Override
            public String getFilename() {
                return "participantes.csv";
            }
        };

        // Preparar request multipart con archivo y probabilidades
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", resource);
        body.add("premio", nombrePremio);
        body.add("agenteHabilitado", agenteHabilitado.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Agente> response = restTemplate.postForEntity(URL_SORTEO, requestEntity, Agente.class);
        return response.getBody();
    }
}
