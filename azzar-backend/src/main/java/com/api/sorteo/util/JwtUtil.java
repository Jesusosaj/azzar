package com.api.sorteo.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.api.sorteo.beans.ClientesTokenResponse;
import com.api.sorteo.beans.UsuarioAdmin;

import java.util.Date;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

	private final SecretKey secretKey; 

    @Autowired
    public JwtUtil(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public String generateToken(ClientesTokenResponse cliente) {
        return Jwts.builder()
                .setSubject(cliente.getCorreo()) 
                .claim("idCliente", cliente.getIdCliente())
                .claim("nombreCliente", cliente.getNombreCliente())
                .claim("sexo", cliente.getSexo())
                .claim("nroDocumento", cliente.getNroDocumento())
                .claim("correo", cliente.getCorreo())
                .claim("telefono", cliente.getTelefono())
                .claim("estado", cliente.getEstado())
                .claim("fechaRegistro", cliente.getFechaRegistro().getTime()) // guardamos como timestamp
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24h
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }
    
    public String generateTokenAdmin(UsuarioAdmin admin) {
        return Jwts.builder()
                .setSubject(admin.getUsuario()) 
                .claim("idUsuario", admin.getIdUsuario())
                .claim("idEmpresa", admin.getIdEmpresa())
                .claim("nombre", admin.getUsuario())
                .claim("fechaRegistro", admin.getFechaRegistro())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24h
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }
}
