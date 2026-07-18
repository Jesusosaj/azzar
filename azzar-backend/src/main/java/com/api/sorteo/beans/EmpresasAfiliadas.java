package com.api.sorteo.beans;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class EmpresasAfiliadas {
    private Integer idEmpresa;
    private String nombreEmpresa;
    private Date fechaDesdeAlquiler;
    private Date fechaHastaAlquiler;
    private Date fechaRegistro;
}
