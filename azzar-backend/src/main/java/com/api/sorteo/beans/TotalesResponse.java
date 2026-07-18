package com.api.sorteo.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalesResponse {
	private Integer totalVentas;
    private Integer totalEventos;
    private Integer totalPremios;
    private Integer totalUsuarios;
}
