package com.api.sorteo.controller;

import com.api.sorteo.beans.CambiarContrasenaRequest;
import com.api.sorteo.beans.Clientes;
import com.api.sorteo.beans.EnvioCorreoRequest;
import com.api.sorteo.beans.LoginRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ClientesController {

    ResponseEntity<List<Clientes>> traerClientes();

    ResponseEntity<Clientes> traerClientePorId(Integer idCliente);

    ResponseEntity<Boolean> crearCliente(Clientes cliente);

    ResponseEntity<Boolean> editarCliente(Integer idCliente, Clientes cliente);

    ResponseEntity<Boolean> eliminarClientePorId(Integer idCliente);
    
    ResponseEntity<String> enviarCodigoCorreo( EnvioCorreoRequest correo);
    
    ResponseEntity<String> login(LoginRequest loginRequest);
    
    ResponseEntity<Boolean> cambiarContrasena(CambiarContrasenaRequest request);
}
