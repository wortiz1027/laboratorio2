package co.edu.javeriana.cotizaciones.repository;

import co.edu.javeriana.cotizaciones.dto.CotizacionCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class CotizacionClienteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int crearCotizacionCliente(CotizacionCliente cotizacionCliente) {
        return jdbcTemplate
                .update("insert into cotizacion_cliente (id_cliente, id_cotizacion_proveedor, fecha_cotizacion) values (?,?,?)",
                        cotizacionCliente.getIdCliente(), cotizacionCliente.getIdCotizacionProveedor(), cotizacionCliente.getFechaCotizacion());
    }

    public int actualizarCotizacionCliente(CotizacionCliente cotizacionCliente) {
        return jdbcTemplate
                .update("update cotizacion_cliente set id_cliente = ?, id_cotizacion_proveedor = ?, fecha_cotizacion = ? where id_cotizacion_cliente = ?",
                        cotizacionCliente.getIdCliente(), cotizacionCliente.getIdCotizacionProveedor(), cotizacionCliente.getFechaCotizacion(), cotizacionCliente.getIdCotizacionCliente());
    }

    public int deleteCotizacionClienteById(BigDecimal idCotizacionCliente) {
        return jdbcTemplate
                .update("delete cotizacion_cliente where id_cotizacion_cliente = ?", idCotizacionCliente);
    }

    public List<CotizacionCliente> findAll() {
        return jdbcTemplate
                .query("select * from cotizacion_cliente",
                        (rs, rowNum) ->
                                new CotizacionCliente(
                                        rs.getBigDecimal("id_cotizacion_cliente"),
                                        rs.getBigDecimal("id_cliente"),
                                        rs.getBigDecimal("id_cotizacion_proveedor"),
                                        rs.getDate("fecha_cotizacion")
                                )
                );
    }

    public Optional<CotizacionCliente> findCotizacionClienteById(BigDecimal idCotizacionCliente) {
        return jdbcTemplate
                .queryForObject("select * from cotizacion_cliente where id_cotizacion_cliente = ?",
                        new Object[]{idCotizacionCliente},
                        (rs, rowNum) ->
                                Optional.of(new CotizacionCliente(
                                        rs.getBigDecimal("id_cotizacion_cliente"),
                                        rs.getBigDecimal("id_cliente"),
                                        rs.getBigDecimal("id_cotizacion_proveedor"),
                                        rs.getDate("fecha_cotizacion")
                                ))
                );
    }
}
