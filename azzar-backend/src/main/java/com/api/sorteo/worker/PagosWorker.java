package com.api.sorteo.worker;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.api.sorteo.dao.PagosDAO;

@Component
public class PagosWorker {

    @Autowired
    private PagosDAO pagoDAO;

    // Cada 1 hora
    /*@Scheduled(fixedRate = 3600000)
    public void verificarPagosExpirados() {
        pagoDAO.liberarRifas();
        System.out.println("Worker ejecutado: Verificando pagos expirados...");
    }*/
}
