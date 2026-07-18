package com.api.sorteo.beans;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemsPago {
    private Integer idVenta;
    private String numeroRifa;
    private String nombreCliente;
    private String nombrePremio;
    private String nombreEvento;
    private String nombreEmpresa;
    private Integer estadoVenta;
    private Date fechaVenta;
    private Double precioRifa;
}
