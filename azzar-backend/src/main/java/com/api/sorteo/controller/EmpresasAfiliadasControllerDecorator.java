package com.api.sorteo.controller;

import com.api.sorteo.beans.EmpresasAfiliadas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/azzar/empresas-afiliadas")
public class EmpresasAfiliadasControllerDecorator implements EmpresasAfiliadasController {

    private final EmpresasAfiliadasController delegate;

    public EmpresasAfiliadasControllerDecorator(EmpresasAfiliadasController delegate) {
        this.delegate = delegate;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<EmpresasAfiliadas>> traerEmpresasAfiliadas() {
        return delegate.traerEmpresasAfiliadas();
    }

    @GetMapping("/{idEmpresa}")
    @Override
    public ResponseEntity<EmpresasAfiliadas> traerEmpresaAfiliadaPorId(@PathVariable Integer idEmpresa) {
        return delegate.traerEmpresaAfiliadaPorId(idEmpresa);
    }

    @PostMapping("/registrar")
    @Override
    public ResponseEntity<Boolean> crearEmpresaAfiliada(@RequestBody EmpresasAfiliadas empresa) {
        return delegate.crearEmpresaAfiliada(empresa);
    }

    @PutMapping("/{idEmpresa}")
    @Override
    public ResponseEntity<Boolean> editarEmpresaAfiliada(@PathVariable Integer idEmpresa,
                                                         @RequestBody EmpresasAfiliadas empresa) {
        return delegate.editarEmpresaAfiliada(idEmpresa, empresa);
    }

    @DeleteMapping("/{idEmpresa}")
    @Override
    public ResponseEntity<Boolean> eliminarEmpresaAfiliadaPorId(@PathVariable Integer idEmpresa) {
        return delegate.eliminarEmpresaAfiliadaPorId(idEmpresa);
    }
}
