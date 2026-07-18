package com.api.sorteo.controller.impl;

import com.api.sorteo.controller.PagosController;
import com.api.sorteo.beans.ReservarComprasRequest;
import com.api.sorteo.beans.ConfirmacionPagoRequest;
import com.api.sorteo.beans.PagoRequest;
import com.api.sorteo.beans.Pagos;
import com.api.sorteo.service.PagosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PagosControllerImpl implements PagosController {

    @Autowired
    private PagosService pagoService;

    @Override
    public ResponseEntity<Boolean> reservarCompras(ReservarComprasRequest request) {
        Boolean resultado = pagoService.reservarCompras(request);
        return ResponseEntity.ok(resultado);
    }

    @Override
    public ResponseEntity<Boolean> confirmarPago(ConfirmacionPagoRequest request) {
        Boolean resultado = pagoService.confirmarPago(request);
        return ResponseEntity.ok(resultado);
    }
    
    @Override
    public ResponseEntity<Boolean> liberarRifaIndividual(Integer IdRifa) {
        Boolean resultado = pagoService.liberarRifaIndividual(IdRifa);
        return ResponseEntity.ok(resultado);
    }
    
    @Override
    public List<Pagos> traerPagos() {
    	List<Pagos> resultado = pagoService.traerPagos();
        return resultado;
    }
    
    @Override
    public ResponseEntity<Boolean> aprobarCompra(PagoRequest request) {
        Boolean resultado = pagoService.aprobarCompra(request.getIdPago());
        return ResponseEntity.ok(resultado);
    }

    @Override
    public ResponseEntity<Boolean> rechazarCompra(PagoRequest request) {
        Boolean resultado = pagoService.rechazarCompra(request.getIdPago());
        return ResponseEntity.ok(resultado);
    }
    
    @Override
    public ResponseEntity<Pagos> traerUltimoPagoIdCliente(Integer IdCliente) {
        Pagos pago = pagoService.traerUltimoPago(IdCliente);
        return ResponseEntity.ok(pago);
    }
    
    @Override
    public ResponseEntity<Boolean> enviarComprobantePago(Integer idCliente, Integer idPago) {
        Boolean enviado = pagoService.enviarCorreoComprobante(idCliente,idPago);
        return ResponseEntity.ok(enviado);
    }
}
