package com.api.sorteo.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.api.sorteo.beans.CambiarContrasenaRequest;
import com.api.sorteo.beans.Clientes;
import com.api.sorteo.beans.EnvioCorreoRequest;
import com.api.sorteo.beans.LoginRequest;
import com.api.sorteo.controller.ClientesController;
import com.api.sorteo.service.ClientesService;
import com.api.sorteo.util.JwtUtil;

@Component
public class ClienteControllerImpl implements ClientesController {

    @Autowired
    private ClientesService clientesService;
    
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<List<Clientes>> traerClientes() {
        List<Clientes> resultado = clientesService.traerClientes();
        return ResponseEntity.ok(resultado);
    }

    @Override
    public ResponseEntity<Clientes> traerClientePorId(Integer idCliente) {
        Clientes resultado = clientesService.traerClientePorId(idCliente);
        return ResponseEntity.ok(resultado);
    }

    @Override
    public ResponseEntity<Boolean> crearCliente(Clientes cliente) {
        Boolean resultado = clientesService.crearCliente(cliente);
        return ResponseEntity.ok(resultado);
    }

    @Override
    public ResponseEntity<Boolean> editarCliente(Integer idCliente, Clientes cliente) {
        Boolean resultado = clientesService.editarCliente(idCliente, cliente);
        return ResponseEntity.ok(resultado);
    }

    @Override
    public ResponseEntity<Boolean> eliminarClientePorId(Integer idCliente) {
        Boolean resultado = clientesService.eliminarClientePorId(idCliente);
        return ResponseEntity.ok(resultado);
    }
    
    @Override
    public ResponseEntity<String> enviarCodigoCorreo(EnvioCorreoRequest correo) {
        String codigoGenerado = clientesService.enviarCodigoCorreo(correo.getCorreo());
        return ResponseEntity.ok(codigoGenerado);
    }

    @Override
    public ResponseEntity<String> login(LoginRequest loginRequest) {
        String token = clientesService.login(loginRequest);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Correo o contraseña incorrectos");
        }
    }

    @Override
    public ResponseEntity<Boolean> cambiarContrasena(CambiarContrasenaRequest request) {
        Boolean resultado = clientesService.cambiarContrasena(request);
        return ResponseEntity.ok(resultado);
    }
}