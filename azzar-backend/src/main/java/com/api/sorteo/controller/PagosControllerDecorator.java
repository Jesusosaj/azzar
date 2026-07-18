package com.api.sorteo.controller;

import com.api.sorteo.beans.ReservarComprasRequest;
import com.api.sorteo.beans.ConfirmacionPagoRequest;
import com.api.sorteo.beans.PagoRequest;
import com.api.sorteo.beans.Pagos;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/azzar/pagos")
public class PagosControllerDecorator implements PagosController {

    private final PagosController pagoControllerDelegate;

    public PagosControllerDecorator(PagosController pagoControllerDelegate) {
        this.pagoControllerDelegate = pagoControllerDelegate;
    }

    @PostMapping("/reservar")
    @Override
    public ResponseEntity<Boolean> reservarCompras(@RequestBody ReservarComprasRequest request) {
        return pagoControllerDelegate.reservarCompras(request);
    }

    @PostMapping(value="/confirmar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<Boolean> confirmarPago(@ModelAttribute ConfirmacionPagoRequest request) {
    	try {
            if (request.getImagenComprobante() != null && !request.getImagenComprobante().isEmpty()) {
                byte[] bytes = request.getImagenComprobante().getBytes();
                String base64 = Base64.getEncoder().encodeToString(bytes);
                request.setImgComprobante(base64);
            }
            return pagoControllerDelegate.confirmarPago(request);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(false);
        }
    }
    
    @DeleteMapping("/eliminar/{IdRifa}")
    @Override
    public ResponseEntity<Boolean> liberarRifaIndividual(@PathVariable Integer IdRifa) {
        return pagoControllerDelegate.liberarRifaIndividual(IdRifa);
    }
    
    @GetMapping("/lista")
    @Override
    public List<Pagos> traerPagos() {
        return pagoControllerDelegate.traerPagos();
    }
    
    @PostMapping("/aprobar")
    @Override
    public ResponseEntity<Boolean> aprobarCompra(@RequestBody PagoRequest request) {
        return pagoControllerDelegate.aprobarCompra(request);
    }
    
    @PostMapping("/rechazar")
    @Override
    public ResponseEntity<Boolean> rechazarCompra(@RequestBody PagoRequest request) {
        return pagoControllerDelegate.rechazarCompra(request);
    }
    
    @GetMapping("/cliente/{IdCliente}")
    @Override
    public ResponseEntity<Pagos> traerUltimoPagoIdCliente(@PathVariable Integer IdCliente) {
        return pagoControllerDelegate.traerUltimoPagoIdCliente(IdCliente);
    }
    
    @PostMapping("/enviar/{idCliente}/{idPago}")
    @Override
    public ResponseEntity<Boolean> enviarComprobantePago(@PathVariable Integer idCliente,@PathVariable Integer idPago) {
        return pagoControllerDelegate.enviarComprobantePago(idCliente,idPago);
    }
}