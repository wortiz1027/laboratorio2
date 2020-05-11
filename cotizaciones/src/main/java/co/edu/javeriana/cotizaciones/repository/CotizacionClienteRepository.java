package co.edu.javeriana.cotizaciones.repository;

import co.edu.javeriana.cotizaciones.dto.Cotizacion;
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

    /*public int crearCotizacionCliente(Cotizacion cotizacion) {
        return jdbcTemplate
                .update("insert into cotizacion_cliente (id_cliente, id_cotizacion_proveedor, fecha_cotizacion) values (?,?,?)",
                        cotizacion.getIdCliente(), cotizacion.getIdCotizacionProveedor(), cotizacion.getFechaCotizacion());
    }

    public int actualizarCotizacionCliente(Cotizacion cotizacion) {
        return jdbcTemplate
                .update("update cotizacion_cliente set id_cliente = ?, id_cotizacion_proveedor = ?, fecha_cotizacion = ? where id_cotizacion_cliente = ?",
                        cotizacion.getIdCliente(), cotizacion.getIdCotizacionProveedor(), cotizacion.getFechaCotizacion(), cotizacion.getIdCotizacionCliente());
    }

    public int deleteCotizacionClienteById(BigDecimal idCotizacionCliente) {
        return jdbcTemplate
                .update("delete cotizacion_cliente where id_cotizacion_cliente = ?", idCotizacionCliente);
    }

    public List<Cotizacion> findAll() {
        return jdbcTemplate
                .query("select * from cotizacion_cliente",
                        (rs, rowNum) ->
                                new Cotizacion(
                                        rs.getBigDecimal("id_cotizacion_cliente"),
                                        rs.getBigDecimal("id_cliente"),
                                        rs.getBigDecimal("id_cotizacion_proveedor"),
                                        rs.getDate("fecha_cotizacion")
                                )
                );
    }

    public Optional<Cotizacion> findCotizacionClienteById(BigDecimal idCotizacionCliente) {
        return jdbcTemplate
                .queryForObject("select * from cotizacion_cliente where id_cotizacion_cliente = ?",
                        new Object[]{idCotizacionCliente},
                        (rs, rowNum) ->
                                Optional.of(new Cotizacion(
                                        rs.getBigDecimal("id_cotizacion_cliente"),
                                        rs.getBigDecimal("id_cliente"),
                                        rs.getBigDecimal("id_cotizacion_proveedor"),
                                        rs.getDate("fecha_cotizacion")
                                ))
                );
    }*/
}
