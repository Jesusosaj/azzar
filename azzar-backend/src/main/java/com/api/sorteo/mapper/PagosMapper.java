package com.api.sorteo.mapper;

import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.SQLException;
import com.api.sorteo.beans.Pagos;

public class PagosMapper implements RowMapper<Pagos> {
    @Override
    public Pagos mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pagos p = new Pagos();
        p.setIdPago(rs.getInt("ID_PAGO"));
        p.setIdPagoPar(rs.getString("ID_PAGO_PAR"));
        p.setReferenciaPago(rs.getString("REFERENCIA_PAGO"));
        p.setEstadoPago(rs.getInt("ESTADO_PAGO"));
        p.setMonto(rs.getDouble("MONTO"));
        p.setFechaCreacion(rs.getTimestamp("FECHA_CREACION"));
        p.setFechaConfirmacion(rs.getTimestamp("FECHA_CONFIRMACION"));
        p.setImagenComprobante(rs.getString("IMAGEN_COMPROBANTE"));
        p.setEsAprobado(rs.getInt("ES_APROBADO"));
        return p;
    }
}
