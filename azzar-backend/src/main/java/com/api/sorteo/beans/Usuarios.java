package com.api.sorteo.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuarios {
	String usuario;
	String nombre;
	String rol;
	Integer id;
	String token;
	@JsonIgnore
	String password;
}
