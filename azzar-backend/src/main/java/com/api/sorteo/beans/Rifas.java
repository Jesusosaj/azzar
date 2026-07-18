package com.api.sorteo.beans;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class Rifas {
    private Integer idRifa;
    private Integer idPremio;
    private String numeroRifa;
    private Integer estadoRifa; // 1 = DISPONIBLE, 2 = PAGADO, 3 = PENDIENTE
    private Date fechaCreacion;
}
