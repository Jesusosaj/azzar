package com.api.sorteo.dao;

import com.api.sorteo.beans.ReservarComprasRequest;

import java.util.List;

import com.api.sorteo.beans.ConfirmacionPagoRequest;
import com.api.sorteo.beans.Pagos;

public interface PagosDAO {
    Boolean reservarCompras(ReservarComprasRequest request);
    Boolean confirmarPago(ConfirmacionPagoRequest request);
    Boolean liberarRifaIndividual(Integer IdRifa);
    String liberarRifas();
    List<Pagos> traerPagos();
    Boolean aprobarCompra(Integer IdPago);
    Boolean rechazarCompra(Integer IdPago);
    Pagos traerUltimoPago(Integer IdCliente);
    Pagos traerPagoCompleto(Integer idPago);
}
