package com.api.sorteo.beans;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
public class Clientes {
    private Integer idCliente;
    private String nombreCliente;
    private String sexo;
    private String nroDocumento;
    private String correo;
    private String contrasena;
    private String telefono;
    private Integer estado;
    private Date fechaRegistro;
}
