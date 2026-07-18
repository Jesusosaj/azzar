package com.api.sorteo.beans;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ConfirmacionPagoRequest {
	private Integer idCliente;
    private List<Integer> rifasLista;
    private String idPagoPar;
    private String referencia;
    private BigDecimal monto;
    private String imgComprobante;
    
    private MultipartFile imagenComprobante;
}