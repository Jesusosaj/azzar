package com.api.sorteo.beans;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Getter
@Setter
public class Premios {
    private Integer idPremio;
    private Integer idEvento;
    private String nombrePremio;
    private String descripcion;
    private String imagen; // guardada en binario
    private BigDecimal precioRifa;
    private Integer estado; // 1 = ACTIVO, 2 = INACTIVO
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date fechaSorteo;
    private Date fechaCreacion;
    
    private MultipartFile imagenPremio; 
}
