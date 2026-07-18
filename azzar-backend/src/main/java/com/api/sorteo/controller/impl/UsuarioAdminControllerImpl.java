package com.api.sorteo.controller.impl;

import com.api.sorteo.controller.UsuarioAdminController;
import com.api.sorteo.beans.UsuarioAdmin;
import com.api.sorteo.service.UsuarioAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/azzar/admin")
public class UsuarioAdminControllerImpl implements UsuarioAdminController {

    @Autowired
    private UsuarioAdminService usuariosAdminService;

    @Override
    public ResponseEntity<List<UsuarioAdmin>> obtenerUsuarios() {
        return ResponseEntity.ok(usuariosAdminService.obtenerUsuarios());
    }

    @Override
    public ResponseEntity<UsuarioAdmin> obtenerUsuarioPorId(int idUsuario) {
        return usuariosAdminService.obtenerUsuarioPorId(idUsuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @Override
    public ResponseEntity<UsuarioAdmin> obtenerUsuarioPorIdEmpresa(int idEmpresa) {
        return usuariosAdminService.obtenerUsuarioPorIdEmpresa(idEmpresa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<String> login(@RequestBody UsuarioAdmin usuario) {
        String token = usuariosAdminService.login(usuario.getUsuario(), usuario.getContrasena());
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
    }

    @Override
    public ResponseEntity<String> registrarUsuario(@RequestBody UsuarioAdmin usuarioAdmin) {
        usuariosAdminService.registrarUsuario(usuarioAdmin);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }

    @Override
    public ResponseEntity<String> actualizarUsuario(@PathVariable int idUsuario, @RequestBody UsuarioAdmin usuarioAdmin) {
        usuarioAdmin.setIdUsuario(idUsuario);
        usuariosAdminService.actualizarUsuario(usuarioAdmin);
        return ResponseEntity.ok("Usuario actualizado correctamente");
    }

    @Override
    public ResponseEntity<String> eliminarUsuario(@PathVariable int idUsuario) {
        usuariosAdminService.eliminarUsuario(idUsuario);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }
}
