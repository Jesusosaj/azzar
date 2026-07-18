package com.api.sorteo.service.impl;

import com.api.sorteo.beans.ReservarComprasRequest;
import com.api.sorteo.beans.Clientes;
import com.api.sorteo.beans.ConfirmacionPagoRequest;
import com.api.sorteo.beans.ItemsPago;
import com.api.sorteo.beans.Pagos;
import com.api.sorteo.dao.ClientesDAO;
import com.api.sorteo.dao.PagosDAO;
import com.api.sorteo.service.PagosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class PagosServiceImpl implements PagosService {

    @Autowired
    private PagosDAO pagoDAO;
    
    @Autowired
    private ClientesDAO clienteDAO;
    
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public Boolean reservarCompras(ReservarComprasRequest request) {
        return pagoDAO.reservarCompras(request);
    }

    @Override
    public Boolean confirmarPago(ConfirmacionPagoRequest request) {
        return pagoDAO.confirmarPago(request);
    }
    
    @Override
    public Boolean liberarRifaIndividual(Integer IdRifa) {
        return pagoDAO.liberarRifaIndividual(IdRifa);
    }
    
    @Override
    public List<Pagos> traerPagos() {
        return pagoDAO.traerPagos();
    }
    
    @Override
    public Boolean aprobarCompra(Integer IdPago) {
        return pagoDAO.aprobarCompra(IdPago);
    }
    
    @Override
    public Boolean rechazarCompra(Integer IdPago) {
        return pagoDAO.rechazarCompra(IdPago);
    }
    
    @Override
    public Pagos traerUltimoPago(Integer IdCliente) {
    	return pagoDAO.traerUltimoPago(IdCliente);
    }
    
    @Override
    public Pagos traerPagoCompleto(Integer idPago) {
        return pagoDAO.traerPagoCompleto(idPago);
    }

    @Override
    public Boolean enviarCorreoComprobante(Integer idCliente, Integer idPago) {
    	Clientes cliente = clienteDAO.traerClientePorId(idCliente);
        Pagos pago = pagoDAO.traerPagoCompleto(idPago);
        if (pago == null) return false;

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Detalle de tu compra:\n\n");
        mensaje.append("Referencia: ").append(pago.getReferenciaPago()).append("\n");
        mensaje.append("Monto Total: ").append(pago.getMonto()).append("\n");
        mensaje.append("Fecha: ").append(pago.getFechaCreacion()).append("\n\n");

        mensaje.append("Rifas Compradas:\n");

        for (ItemsPago item : pago.getItems()) {
            mensaje.append("- Rifa ").append(item.getNumeroRifa())
                   .append(" | Premio: ").append(item.getNombrePremio())
                   .append(" | Evento: ").append(item.getNombreEvento())
                   .append(" | Empresa: ").append(item.getNombreEmpresa())
                   .append(" | Precio: ").append(item.getPrecioRifa())
                   .append("\n");
        }

        SimpleMailMessage correo = new SimpleMailMessage();
        correo.setTo(cliente.getCorreo());
        correo.setSubject("Comprobante de Compra - Pago " + idPago);
        correo.setText(mensaje.toString());

        mailSender.send(correo);
        
        return true;
    }
}
