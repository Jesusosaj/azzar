package com.api.sorteo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.sorteo.beans.Rifas;
import com.api.sorteo.dao.RifasDAO;
import com.api.sorteo.service.RifasService;

@Service
public class RifasServiceImpl implements RifasService {

    @Autowired
    private RifasDAO rifasDAO;

    @Override
    public List<Rifas> traerRifas() {
        return rifasDAO.traerRifas();
    }

    @Override
    public Rifas traerRifaPorId(Integer idRifa) {
        return rifasDAO.traerRifaPorId(idRifa);
    }

    @Override
    public List<Rifas> traerRifasPorPremio(Integer idPremio) {
        return rifasDAO.traerRifasPorPremio(idPremio);
    }

    @Override
    public Boolean crearRifas(Integer idPremio, Integer cantidad) {
        return rifasDAO.crearRifas(idPremio, cantidad);
    }

    @Override
    public Boolean editarRifa(Integer idRifa, Rifas rifa) {
        return rifasDAO.editarRifa(idRifa, rifa);
    }

    @Override
    public Boolean eliminarRifaPorId(Integer idRifa) {
        return rifasDAO.eliminarRifaPorId(idRifa);
    }
}
