package com.api.sorteo.service.impl;

import com.api.sorteo.dao.UsuarioAdminDAO;
import com.api.sorteo.beans.UsuarioAdmin;
import com.api.sorteo.service.UsuarioAdminService;
import com.api.sorteo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioAdminServiceImpl implements UsuarioAdminService {

    @Autowired
    private UsuarioAdminDAO usuariosAdminDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public List<UsuarioAdmin> obtenerUsuarios() {
        return usuariosAdminDAO.obtenerUsuarios();
    }

    @Override
    public Optional<UsuarioAdmin> obtenerUsuarioPorId(int idUsuario) {
        return usuariosAdminDAO.obtenerUsuarioPorId(idUsuario);
    }
    
    @Override
    public Optional<UsuarioAdmin> obtenerUsuarioPorIdEmpresa(int idEmpresa) {
        return usuariosAdminDAO.obtenerUsuarioPorIdEmpresa(idEmpresa);
    }

    @Override
    public String login(String usuario, String contrasena) {
        Optional<UsuarioAdmin> userOpt = usuariosAdminDAO.obtenerUsuarioPorNombre(usuario);
        if (userOpt.isPresent()) {
            UsuarioAdmin user = userOpt.get();
            if (passwordEncoder.matches(contrasena, user.getContrasena())) {
                return jwtUtil.generateTokenAdmin(user);
            }
        }
        return null;
    }

    @Override
    public int registrarUsuario(UsuarioAdmin usuarioAdmin) {
        usuarioAdmin.setContrasena(passwordEncoder.encode(usuarioAdmin.getContrasena()));
        return usuariosAdminDAO.registrarUsuario(usuarioAdmin);
    }

    @Override
    public int actualizarUsuario(UsuarioAdmin usuarioAdmin) {
        usuarioAdmin.setContrasena(passwordEncoder.encode(usuarioAdmin.getContrasena()));
        return usuariosAdminDAO.actualizarUsuario(usuarioAdmin);
    }

    @Override
    public int eliminarUsuario(int idUsuario) {
        return usuariosAdminDAO.eliminarUsuario(idUsuario);
    }
}
