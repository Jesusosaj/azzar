package com.api.sorteo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sorteo.beans.Premios;
import com.api.sorteo.dao.PremiosDAO;
import com.api.sorteo.service.PremiosService;

@Service
public class PremiosServiceImpl implements PremiosService {

    @Autowired
    private PremiosDAO premiosDAO;

    @Override
    public List<Premios> traerPremios() {
        return premiosDAO.traerPremios();
    }

    @Override
    public Premios traerPremioPorId(Integer idPremio) {
        return premiosDAO.traerPremioPorId(idPremio);
    }

    @Override
    public List<Premios> traerPremiosPorEvento(Integer idEvento) {
        return premiosDAO.traerPremiosPorEvento(idEvento);
    }

    @Override
    public Boolean crearPremio(Premios premio) {
        return premiosDAO.crearPremio(premio);
    }

    @Override
    public Boolean editarPremio(Integer idPremio, Premios premio) {
        return premiosDAO.editarPremio(idPremio, premio);
    }

    @Override
    public Boolean eliminarPremioPorId(Integer idPremio) {
        return premiosDAO.eliminarPremioPorId(idPremio);
    }
}
