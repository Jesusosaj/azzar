package com.api.sorteo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioAdmin {
    private int idUsuario;
    private int idEmpresa;
    private String usuario;
    private String contrasena;
    private String fechaRegistro;
}
