package com.api.sorteo.controller;

import com.api.sorteo.beans.CambiarContrasenaRequest;
import com.api.sorteo.beans.Clientes;
import com.api.sorteo.beans.EnvioCorreoRequest;
import com.api.sorteo.beans.LoginRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/azzar/clientes")
public class ClientesControllerDecorator implements ClientesController {

    private final ClientesController clientesControllerDelegate;

    public ClientesControllerDecorator(ClientesController clientesControllerDelegate) {
        this.clientesControllerDelegate = clientesControllerDelegate;
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Clientes>> traerClientes() {
        return clientesControllerDelegate.traerClientes();
    }

    @GetMapping("/{idCliente}")
    @Override
    public ResponseEntity<Clientes> traerClientePorId(@PathVariable Integer idCliente) {
        return clientesControllerDelegate.traerClientePorId(idCliente);
    }

    @PostMapping("/registrar")
    @Override
    public ResponseEntity<Boolean> crearCliente(@RequestBody Clientes cliente) {
        return clientesControllerDelegate.crearCliente(cliente);
    }
    
    @PostMapping("/enviar-correo")
    @Override
    public ResponseEntity<String> enviarCodigoCorreo(@RequestBody EnvioCorreoRequest correo) {
        return clientesControllerDelegate.enviarCodigoCorreo(correo);
    }

    @PutMapping("/{idCliente}")
    @Override
    public ResponseEntity<Boolean> editarCliente(@PathVariable Integer idCliente, @RequestBody Clientes cliente) {
        return clientesControllerDelegate.editarCliente(idCliente, cliente);
    }

    @DeleteMapping("/{idCliente}")
    @Override
    public ResponseEntity<Boolean> eliminarClientePorId(@PathVariable Integer idCliente) {
        return clientesControllerDelegate.eliminarClientePorId(idCliente);
    }
    
    @PostMapping("/login")
    @Override
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        return clientesControllerDelegate.login(loginRequest);
    }
    
    @PostMapping("/cambiar/password")
    @Override
    public ResponseEntity<Boolean> cambiarContrasena(@RequestBody CambiarContrasenaRequest request) {
        return clientesControllerDelegate.cambiarContrasena(request);
    }
}

