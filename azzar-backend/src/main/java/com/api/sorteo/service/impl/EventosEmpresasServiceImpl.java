package com.api.sorteo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sorteo.beans.EventosEmpresas;
import com.api.sorteo.dao.EventosEmpresasDAO;
import com.api.sorteo.service.EventosEmpresasService;

@Service
public class EventosEmpresasServiceImpl implements EventosEmpresasService {

    @Autowired
    private EventosEmpresasDAO eventosEmpresasDAO;

    @Override
    public List<EventosEmpresas> traerEventos() {
        return eventosEmpresasDAO.traerEventos();
    }

    @Override
    public EventosEmpresas traerEventoPorId(Integer idEvento) {
        return eventosEmpresasDAO.traerEventoPorId(idEvento);
    }

    @Override
    public List<EventosEmpresas> traerEventosPorEmpresa(Integer idEmpresa) {
        return eventosEmpresasDAO.traerEventosPorEmpresa(idEmpresa);
    }

    @Override
    public Boolean crearEvento(EventosEmpresas evento) {
        return eventosEmpresasDAO.crearEvento(evento);
    }

    @Override
    public Boolean editarEvento(Integer idEvento, EventosEmpresas evento) {
        return eventosEmpresasDAO.editarEvento(idEvento, evento);
    }

    @Override
    public Boolean eliminarEventoPorId(Integer idEvento) {
        return eventosEmpresasDAO.eliminarEventoPorId(idEvento);
    }
}
