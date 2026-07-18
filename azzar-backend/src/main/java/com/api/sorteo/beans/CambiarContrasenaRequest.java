package com.api.sorteo.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CambiarContrasenaRequest {
    private String correo;
    private String nuevaContrasena;
}
