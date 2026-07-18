package com.api.sorteo.service;

import java.util.List;
import com.api.sorteo.beans.EventosEmpresas;

public interface EventosEmpresasService {

    List<EventosEmpresas> traerEventos();

    EventosEmpresas traerEventoPorId(Integer idEvento);

    List<EventosEmpresas> traerEventosPorEmpresa(Integer idEmpresa);

    Boolean crearEvento(EventosEmpresas evento);

    Boolean editarEvento(Integer idEvento, EventosEmpresas evento);

    Boolean eliminarEventoPorId(Integer idEvento);
}
