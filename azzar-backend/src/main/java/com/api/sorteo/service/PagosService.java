package com.api.sorteo.service;

import com.api.sorteo.beans.ReservarComprasRequest;

import java.util.List;

import com.api.sorteo.beans.ConfirmacionPagoRequest;
import com.api.sorteo.beans.Pagos;

public interface PagosService {
    Boolean reservarCompras(ReservarComprasRequest request);
    Boolean confirmarPago(ConfirmacionPagoRequest request);
    Boolean liberarRifaIndividual(Integer IdRifa);
    List<Pagos> traerPagos();
    
    Boolean aprobarCompra(Integer IdPago);
    Boolean rechazarCompra(Integer IdPago);
    
    Pagos traerUltimoPago(Integer IdCliente);
    
    Pagos traerPagoCompleto(Integer idPago);

    Boolean enviarCorreoComprobante(Integer idCliente, Integer idPago);

}