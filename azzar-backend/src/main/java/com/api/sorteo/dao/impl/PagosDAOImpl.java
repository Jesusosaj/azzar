package com.api.sorteo.dao.impl;

import com.api.sorteo.dao.PagosDAO;
import com.api.sorteo.beans.ReservarComprasRequest;
import com.api.sorteo.beans.ConfirmacionPagoRequest;
import com.api.sorteo.beans.ItemsPago;
import com.api.sorteo.beans.Pagos;
import com.api.sorteo.mapper.ItemsPagoMapper;
import com.api.sorteo.mapper.PagosMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PagosDAOImpl implements PagosDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final String TRAER_PAGOS = "SELECT * FROM PAGOS";

    private static final String TRAER_ITEMS_PAGO = "SELECT V.ID_VENTA, R.NUMERO_RIFA, C.NOMBRE_CLIENTE, " +
            "P.NOMBRE_PREMIO, EE.NOMBRE_EVENTO, EA.NOMBRE_EMPRESA, V.ESTADO_VENTA, V.FECHA_VENTA, P.PRECIO_RIFA " +
            "FROM VENTAS V INNER JOIN RIFAS R ON V.ID_RIFA = R.ID_RIFA " +
            "INNER JOIN PREMIOS P ON R.ID_PREMIO = P.ID_PREMIO " +
            "INNER JOIN EVENTOS_EMPRESA EE ON P.ID_EVENTO = EE.ID_EVENTO " +
            "INNER JOIN EMPRESAS_AFILIADAS EA ON EE.ID_EMPRESA = EA.ID_EMPRESA " +
            "INNER JOIN CLIENTES C ON V.ID_CLIENTE = C.ID_CLIENTE " +
            "WHERE V.ID_PAGO = ?";
    
    private static final String TRAER_ULTIMO_PAGO = """
    	    SELECT p.ID_PAGO, p.ID_PAGO_PAR, p.REFERENCIA_PAGO, p.ESTADO_PAGO,
    	           p.MONTO, p.FECHA_CREACION, p.FECHA_CONFIRMACION,
    	           p.IMAGEN_COMPROBANTE, p.ES_APROBADO
    	    FROM PAGOS p
    	    INNER JOIN VENTAS v ON p.ID_PAGO = v.ID_PAGO
    	    WHERE v.ID_CLIENTE = ?
    	    ORDER BY p.FECHA_CREACION DESC
    	    FETCH FIRST 1 ROWS ONLY
    	""";

    	@Override
    	public Pagos traerUltimoPago(Integer IdCliente) {

    	    List<Pagos> lista = jdbcTemplate.query(TRAER_ULTIMO_PAGO, new PagosMapper(), IdCliente);

    	    if (lista.isEmpty()) {
    	        return null; // <--- no revienta, retorna null
    	    }

    	    return lista.get(0);
    	}

    @Override
    public Boolean reservarCompras(ReservarComprasRequest request) {
    	String rifasLista = String.join(
                ",", 
                request.getRifasLista().stream().map(String::valueOf).toList()
        );

        jdbcTemplate.update(
            "CALL pkg_rifas.ReservarCompras(?, ?, ?)",
            request.getIdCliente(),
            rifasLista,
            request.getMinutosExpiracion()
        );

        return true;
    }
    
    @Override
    public Boolean liberarRifaIndividual(Integer IdRifa) {

    	jdbcTemplate.update("CALL pkg_rifas.LiberarRifa(?)", IdRifa);

        return true;
    }

    @Override
    public Boolean confirmarPago(ConfirmacionPagoRequest request) {

        String rifasLista = String.join(
            ",",
            request.getRifasLista().stream().map(String::valueOf).toList()
        );

        String imagenComprobanteClob = null;

        try {
            if (request.getImagenComprobante() != null && !request.getImagenComprobante().isEmpty()) {
                imagenComprobanteClob = Base64.getEncoder().encodeToString(
                    request.getImagenComprobante().getBytes()
                );
            } else if (request.getImgComprobante() != null && !request.getImgComprobante().isEmpty()) {
                imagenComprobanteClob = request.getImgComprobante();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error procesando comprobante: " + e.getMessage());
        }

        jdbcTemplate.update(
            "CALL pkg_rifas.ConfirmarPagoCompras(?, ?, ?, ?, ?, ?)",
            request.getIdCliente(),
            rifasLista,
            request.getIdPagoPar(),
            request.getReferencia(),
            request.getMonto(),
            imagenComprobanteClob
        );

        return true;
    }

    
    @Override
    public String liberarRifas() {
        jdbcTemplate.update("BEGIN pkg_rifas.LiberarRifasExpiradas(); END;");
        return "Rifas liberadas...";
    }
    
    @Override
    public List<Pagos> traerPagos() {
        List<Pagos> pagos = jdbcTemplate.query(TRAER_PAGOS, (rs, rowNum) -> {
            Pagos pago = new Pagos();
            pago.setIdPago(rs.getInt("ID_PAGO"));
            pago.setIdPagoPar(rs.getString("ID_PAGO_PAR"));
            pago.setReferenciaPago(rs.getString("REFERENCIA_PAGO"));
            pago.setEstadoPago(rs.getInt("ESTADO_PAGO"));
            pago.setMonto(rs.getDouble("MONTO"));
            pago.setFechaCreacion(rs.getTimestamp("FECHA_CREACION"));
            pago.setFechaConfirmacion(rs.getTimestamp("FECHA_CONFIRMACION"));
            pago.setImagenComprobante(rs.getString("IMAGEN_COMPROBANTE"));
            pago.setEsAprobado(rs.getInt("ES_APROBADO"));

            List<ItemsPago> items = jdbcTemplate.query(TRAER_ITEMS_PAGO, new ItemsPagoMapper(), pago.getIdPago());
            pago.setItems(items);

            return pago;
        });

        return pagos;
    }
    
    @Override
    public Boolean rechazarCompra(Integer IdPago) {

    	jdbcTemplate.update("CALL pkg_rifas.RechazarCompra(?)", IdPago);

        return true;
    }
    
    @Override
    public Boolean aprobarCompra(Integer IdPago) {

    	jdbcTemplate.update("CALL pkg_rifas.AprobarCompra(?)", IdPago);

        return true;
    }
    
    private static final String TRAER_PAGO =
            "SELECT * FROM PAGOS WHERE ID_PAGO = ?";

        private static final String TRAER_ITEMS =
            """
            SELECT 
                V.ID_VENTA,
                R.NUMERO_RIFA,
                C.NOMBRE_CLIENTE,
                P.NOMBRE_PREMIO,
                EE.NOMBRE_EVENTO,
                EA.NOMBRE_EMPRESA,
                V.ESTADO_VENTA,
                V.FECHA_VENTA,
                P.PRECIO_RIFA
            FROM VENTAS V 
            INNER JOIN RIFAS R ON V.ID_RIFA = R.ID_RIFA
            INNER JOIN PREMIOS P ON R.ID_PREMIO = P.ID_PREMIO
            INNER JOIN EVENTOS_EMPRESA EE ON P.ID_EVENTO = EE.ID_EVENTO
            INNER JOIN EMPRESAS_AFILIADAS EA ON EE.ID_EMPRESA = EA.ID_EMPRESA
            INNER JOIN CLIENTES C ON V.ID_CLIENTE = C.ID_CLIENTE
            WHERE V.ID_PAGO = ?
            """;

        @Override
        public Pagos traerPagoCompleto(Integer idPago) {
            try {
                Pagos pago = jdbcTemplate.queryForObject(TRAER_PAGO, (rs, row) -> mapPago(rs), idPago);

                if (pago == null) return null;

                List<ItemsPago> items = jdbcTemplate.query(TRAER_ITEMS,
                    (rs, row) -> mapItems(rs), idPago);

                pago.setItems(items);
                return pago;

            } catch (EmptyResultDataAccessException ex) {
                return null;
            }
        }

        private Pagos mapPago(ResultSet rs) throws SQLException {
            Pagos pago = new Pagos();
            pago.setIdPago(rs.getInt("ID_PAGO"));
            pago.setIdPagoPar(rs.getString("ID_PAGO_PAR"));
            pago.setReferenciaPago(rs.getString("REFERENCIA_PAGO"));
            pago.setEstadoPago(rs.getInt("ESTADO_PAGO"));
            pago.setMonto(rs.getDouble("MONTO"));
            pago.setFechaCreacion(rs.getTimestamp("FECHA_CREACION"));
            pago.setFechaConfirmacion(rs.getTimestamp("FECHA_CONFIRMACION"));
            pago.setImagenComprobante(rs.getString("IMAGEN_COMPROBANTE"));
            pago.setEsAprobado(rs.getInt("ES_APROBADO"));
            return pago;
        }

        private ItemsPago mapItems(ResultSet rs) throws SQLException {
            ItemsPago item = new ItemsPago();
            item.setIdVenta(rs.getInt("ID_VENTA"));
            item.setNumeroRifa(rs.getString("NUMERO_RIFA"));
            item.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
            item.setNombrePremio(rs.getString("NOMBRE_PREMIO"));
            item.setNombreEvento(rs.getString("NOMBRE_EVENTO"));
            item.setNombreEmpresa(rs.getString("NOMBRE_EMPRESA"));
            item.setEstadoVenta(rs.getInt("ESTADO_VENTA"));
            item.setFechaVenta(rs.getTimestamp("FECHA_VENTA"));
            item.setPrecioRifa(rs.getDouble("PRECIO_RIFA"));
            return item;
        }
    
}
