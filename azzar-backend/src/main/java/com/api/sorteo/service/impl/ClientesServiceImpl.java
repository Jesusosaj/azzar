package com.api.sorteo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.sorteo.beans.CambiarContrasenaRequest;
import com.api.sorteo.beans.Clientes;
import com.api.sorteo.beans.ClientesTokenResponse;
import com.api.sorteo.beans.LoginRequest;
import com.api.sorteo.service.ClientesService;
import com.api.sorteo.util.JwtUtil;
import com.api.sorteo.dao.ClientesDAO;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesDAO clientesDAO;
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public List<Clientes> traerClientes() {
        return clientesDAO.traerClientes();
    }

    @Override
    public Clientes traerClientePorId(Integer idCliente) {
        return clientesDAO.traerClientePorId(idCliente);
    }

    @Override
    public Boolean crearCliente(Clientes cliente) {
        return clientesDAO.crearCliente(cliente);
    }

    @Override
    public Boolean editarCliente(Integer idCliente, Clientes cliente) {
        return clientesDAO.editarCliente(idCliente, cliente);
    }

    @Override
    public Boolean eliminarClientePorId(Integer idCliente) {
        return clientesDAO.eliminarClientePorId(idCliente);
    }
    
    @Override
    public String enviarCodigoCorreo(String correo) {
        String codigo = String.format("%06d", (int)(Math.random() * 1000000));

        try {
        	SimpleMailMessage mensaje = new SimpleMailMessage();
            mensaje.setTo(correo);
            mensaje.setSubject("Código de verificación");
            mensaje.setText("Tu código de verificación es: " + codigo);
            mailSender.send(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al enviar el correo");
        }

        return codigo;
    }

    @Override
    public String login(LoginRequest loginRequest) {
        Clientes cliente = clientesDAO.traerClientePorCorreo(loginRequest.getCorreo());
        if (cliente != null) {
            if (passwordEncoder.matches(loginRequest.getContrasena(), cliente.getContrasena())) {
            	ClientesTokenResponse clienteToken = new ClientesTokenResponse();
            	
            	clienteToken.setNombreCliente(cliente.getNombreCliente());
            	clienteToken.setCorreo(cliente.getCorreo());
            	clienteToken.setEstado(cliente.getEstado());
            	clienteToken.setFechaRegistro(cliente.getFechaRegistro());
            	clienteToken.setIdCliente(cliente.getIdCliente());
            	clienteToken.setNroDocumento(cliente.getNroDocumento());
            	clienteToken.setSexo(cliente.getSexo());
            	clienteToken.setTelefono(cliente.getTelefono());
            	
                return jwtUtil.generateToken(clienteToken);
            }
        }
        return null; 
    }
    
    @Override
    public Boolean cambiarContrasena(CambiarContrasenaRequest request) {
        Clientes cliente = clientesDAO.traerClientePorCorreo(request.getCorreo());
        if (cliente == null) {
            return false;
        }
        String hashedPassword = passwordEncoder.encode(request.getNuevaContrasena());
        return clientesDAO.actualizarContrasena(cliente.getIdCliente(), hashedPassword);
    }
}
