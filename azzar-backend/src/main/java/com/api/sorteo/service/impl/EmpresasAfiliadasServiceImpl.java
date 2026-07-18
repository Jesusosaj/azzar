package com.api.sorteo.service.impl;

import com.api.sorteo.beans.EmpresasAfiliadas;
import com.api.sorteo.dao.EmpresasAfiliadasDAO;
import com.api.sorteo.service.EmpresasAfiliadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpresasAfiliadasServiceImpl implements EmpresasAfiliadasService {

    @Autowired
    private EmpresasAfiliadasDAO dao;

    @Override
    public List<EmpresasAfiliadas> traerEmpresasAfiliadas() {
        return dao.traerEmpresasAfiliadas();
    }

    @Override
    public EmpresasAfiliadas traerEmpresaAfiliadaPorId(Integer idEmpresa) {
        return dao.traerEmpresaAfiliadaPorId(idEmpresa);
    }

    @Override
    public Boolean crearEmpresaAfiliada(EmpresasAfiliadas empresa) {
        return dao.crearEmpresaAfiliada(empresa);
    }

    @Override
    public Boolean editarEmpresaAfiliada(Integer idEmpresa, EmpresasAfiliadas empresa) {
        return dao.editarEmpresaAfiliada(idEmpresa, empresa);
    }

    @Override
    public Boolean eliminarEmpresaAfiliadaPorId(Integer idEmpresa) {
        return dao.eliminarEmpresaAfiliadaPorId(idEmpresa);
    }
}
