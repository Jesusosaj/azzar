package com.api.sorteo.controller.impl;

import com.api.sorteo.beans.EmpresasAfiliadas;
import com.api.sorteo.controller.EmpresasAfiliadasController;
import com.api.sorteo.service.EmpresasAfiliadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class EmpresasAfiliadasControllerImpl implements EmpresasAfiliadasController {

    @Autowired
    private EmpresasAfiliadasService service;

    @Override
    public ResponseEntity<List<EmpresasAfiliadas>> traerEmpresasAfiliadas() {
        return ResponseEntity.ok(service.traerEmpresasAfiliadas());
    }

    @Override
    public ResponseEntity<EmpresasAfiliadas> traerEmpresaAfiliadaPorId(Integer idEmpresa) {
        return ResponseEntity.ok(service.traerEmpresaAfiliadaPorId(idEmpresa));
    }

    @Override
    public ResponseEntity<Boolean> crearEmpresaAfiliada(EmpresasAfiliadas empresa) {
        return ResponseEntity.ok(service.crearEmpresaAfiliada(empresa));
    }

    @Override
    public ResponseEntity<Boolean> editarEmpresaAfiliada(Integer idEmpresa, EmpresasAfiliadas empresa) {
        return ResponseEntity.ok(service.editarEmpresaAfiliada(idEmpresa, empresa));
    }

    @Override
    public ResponseEntity<Boolean> eliminarEmpresaAfiliadaPorId(Integer idEmpresa) {
        return ResponseEntity.ok(service.eliminarEmpresaAfiliadaPorId(idEmpresa));
    }
}
