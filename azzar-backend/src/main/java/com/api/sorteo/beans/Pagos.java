package com.api.sorteo.beans;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagos {
	private Integer IdPago;
	private String IdPagoPar;
	private String ReferenciaPago;
	private Integer EstadoPago;
	private Double Monto;
	private Date FechaCreacion;
	private Date FechaConfirmacion;
	private String ImagenComprobante;
	private Integer EsAprobado;
	private List<ItemsPago> Items;
}
