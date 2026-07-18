package com.api.sorteo.dao;

import com.api.sorteo.beans.UsuarioAdmin;
import java.util.List;
import java.util.Optional;

public interface UsuarioAdminDAO {
    List<UsuarioAdmin> obtenerUsuarios();
    Optional<UsuarioAdmin> obtenerUsuarioPorId(int idUsuario);
    Optional<UsuarioAdmin> obtenerUsuarioPorIdEmpresa(int idEmpresa);
    Optional<UsuarioAdmin> obtenerUsuarioPorNombre(String usuario);
    int registrarUsuario(UsuarioAdmin usuarioAdmin);
    int actualizarUsuario(UsuarioAdmin usuarioAdmin);
    int eliminarUsuario(int idUsuario);
}
