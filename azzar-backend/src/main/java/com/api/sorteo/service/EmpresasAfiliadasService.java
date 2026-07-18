package com.api.sorteo.service;

import com.api.sorteo.beans.EmpresasAfiliadas;
import java.util.List;

public interface EmpresasAfiliadasService {
    List<EmpresasAfiliadas> traerEmpresasAfiliadas();
    EmpresasAfiliadas traerEmpresaAfiliadaPorId(Integer idEmpresa);
    Boolean crearEmpresaAfiliada(EmpresasAfiliadas empresa);
    Boolean editarEmpresaAfiliada(Integer idEmpresa, EmpresasAfiliadas empresa);
    Boolean eliminarEmpresaAfiliadaPorId(Integer idEmpresa);
}
