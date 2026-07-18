package com.api.sorteo.beans;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Paso1 {
    private String idUsuario;
    private List<Item> items; 

    @Getter
    @Setter
    public static class Item {
        private String idPremio;
        private int cantidadTickets;
        private double precioUnitario;
    }
}