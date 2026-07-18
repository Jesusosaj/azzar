package com.api.sorteo.controller;

import com.api.sorteo.beans.EmpresasAfiliadas;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface EmpresasAfiliadasController {

    ResponseEntity<List<EmpresasAfiliadas>> traerEmpresasAfiliadas();

    ResponseEntity<EmpresasAfiliadas> traerEmpresaAfiliadaPorId(Integer idEmpresa);

    ResponseEntity<Boolean> crearEmpresaAfiliada(EmpresasAfiliadas empresa);

    ResponseEntity<Boolean> editarEmpresaAfiliada(Integer idEmpresa, EmpresasAfiliadas empresa);

    ResponseEntity<Boolean> eliminarEmpresaAfiliadaPorId(Integer idEmpresa);
}
