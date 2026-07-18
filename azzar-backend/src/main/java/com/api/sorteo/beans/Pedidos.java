package com.api.sorteo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedidos {
    private String numeroRifa;
    private Double precioRifa;
    private String nombrePremio;
    private Integer idVenta;
    private Integer idRifa;
}
