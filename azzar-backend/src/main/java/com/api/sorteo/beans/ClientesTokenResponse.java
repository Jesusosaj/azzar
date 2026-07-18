package com.api.sorteo.beans;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientesTokenResponse {
	 private Integer idCliente;
	 private String nombreCliente;
	 private String sexo;
	 private String nroDocumento;
	 private String correo;
	 private String telefono;
	 private Integer estado;
	 private Date fechaRegistro;
}
