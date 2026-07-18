package com.api.sorteo.beans;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ReservarComprasRequest {
	private Integer idCliente;
    private List<Integer> rifasLista;
    private Integer minutosExpiracion = 1440;
}