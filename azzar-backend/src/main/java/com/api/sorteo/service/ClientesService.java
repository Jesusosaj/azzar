package com.api.sorteo.service;

import java.util.List;

import com.api.sorteo.beans.CambiarContrasenaRequest;
import com.api.sorteo.beans.Clientes;
import com.api.sorteo.beans.LoginRequest;

public interface ClientesService {

    List<Clientes> traerClientes();

    Clientes traerClientePorId(Integer idCliente);

    Boolean crearCliente(Clientes cliente);

    Boolean editarCliente(Integer idCliente, Clientes cliente);

    Boolean eliminarClientePorId(Integer idCliente);
    
    String enviarCodigoCorreo(String correo);
    
    String login(LoginRequest loginRequest);
    
    Boolean cambiarContrasena(CambiarContrasenaRequest request);
}
