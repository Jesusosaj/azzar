package com.api.sorteo.beans;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Ventas {
    private Integer idVenta;
    private Integer idPremio;
    private String nombreEmpresa;
    private String nombreEvento;
    private String nombrePremio;
    private String numeroRifa;
    private String nombreCliente;
    private String sexo;
    private Integer estadoVenta;
    private LocalDateTime fechaVenta;
    private Double precioRifa;
}
