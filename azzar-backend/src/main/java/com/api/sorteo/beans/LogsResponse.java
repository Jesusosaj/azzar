package com.api.sorteo.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogsResponse {
    private Integer idLog;
    private String nombreCliente;
    private String descripcionAccion;
    private String detalle;
    private String fechaHora; // fecha y hora del log
}
