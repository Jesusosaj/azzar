package com.api.sorteo.dao;

import java.util.List;

import com.api.sorteo.beans.Clientes;

public interface ClientesDAO {

    // Traer todos los clientes
    List<Clientes> traerClientes();

    // Traer cliente por ID
    Clientes traerClientePorId(Integer idCliente);

    // Crear nuevo cliente
    Boolean crearCliente(Clientes cliente);

    // Editar cliente existente
    Boolean editarCliente(Integer idCliente, Clientes cliente);

    // Eliminar cliente por ID
    Boolean eliminarClientePorId(Integer idCliente);
    
    Clientes traerClientePorCorreo(String correo);
    
    Boolean actualizarContrasena(Integer idCliente, String nuevaContrasena);
}
