package com.api.sorteo.controller;

import com.api.sorteo.beans.UsuarioAdmin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admins")
public interface UsuarioAdminController {

    @GetMapping
    ResponseEntity<List<UsuarioAdmin>> obtenerUsuarios();

    @GetMapping("/{idUsuario}")
    ResponseEntity<UsuarioAdmin> obtenerUsuarioPorId(int idUsuario);
    
    @GetMapping("/empresa/{idEmpresa}")
    ResponseEntity<UsuarioAdmin> obtenerUsuarioPorIdEmpresa( int idEmpresa);

    @PostMapping("/login")
    ResponseEntity<String> login(UsuarioAdmin usuario);

    @PostMapping("/registrar")
    ResponseEntity<String> registrarUsuario(UsuarioAdmin usuarioAdmin);

    @PutMapping("/{idUsuario}")
    ResponseEntity<String> actualizarUsuario( int idUsuario,  UsuarioAdmin usuarioAdmin);

    @DeleteMapping("/{idUsuario}")
    ResponseEntity<String> eliminarUsuario( int idUsuario);
}
