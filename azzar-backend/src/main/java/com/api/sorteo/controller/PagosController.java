package com.api.sorteo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.sorteo.beans.ConfirmacionPagoRequest;
import com.api.sorteo.beans.PagoRequest;
import com.api.sorteo.beans.Pagos;
import com.api.sorteo.beans.ReservarComprasRequest;

public interface PagosController {

    ResponseEntity<Boolean> reservarCompras(ReservarComprasRequest request);

    ResponseEntity<Boolean> confirmarPago(ConfirmacionPagoRequest request);

    ResponseEntity<Boolean> liberarRifaIndividual(Integer IdRifa);

    List<Pagos> traerPagos();

    ResponseEntity<Boolean> aprobarCompra(PagoRequest request);

    ResponseEntity<Boolean> rechazarCompra(PagoRequest request);

    ResponseEntity<Pagos>  traerUltimoPagoIdCliente(Integer IdCliente);
    ResponseEntity<Boolean> enviarComprobantePago(Integer idCliente, Integer idPago);
}
