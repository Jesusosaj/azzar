package com.api.sorteo.service;

import com.api.sorteo.beans.UsuarioAdmin;
import java.util.List;
import java.util.Optional;

public interface UsuarioAdminService {
    List<UsuarioAdmin> obtenerUsuarios();
    Optional<UsuarioAdmin> obtenerUsuarioPorId(int idUsuario);
    Optional<UsuarioAdmin> obtenerUsuarioPorIdEmpresa(int idEmpresa);
    String login(String usuario, String contrasena);
    int registrarUsuario(UsuarioAdmin usuarioAdmin);
    int actualizarUsuario(UsuarioAdmin usuarioAdmin);
    int eliminarUsuario(int idUsuario);
}
