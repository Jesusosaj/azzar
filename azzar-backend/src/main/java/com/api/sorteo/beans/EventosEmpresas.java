package com.api.sorteo.beans;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class EventosEmpresas {
    private Integer idEvento;
    private Integer idEmpresa;
    private String nombreEvento;
    private String ubicacionEvento;
    private String imagenFlyer;
    private Date fechaRegistro;
    
    private MultipartFile imagenFlyerFile; 
}
