package co.edu.javeriana.cotizaciones.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class CotizacionProveedorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*public int crearCotizacionProveedor(CotizacionProveedor cotizacionProveedor) {
        return jdbcTemplate
                .update("insert into cotizacion_proveedor (id_cotizacion_cliente, fecha_cotizacion) values (?,?)",
                        cotizacionProveedor.getIdCotizacionCliente(), cotizacionProveedor.getFechaCotizacion());
    }

    public int actualizarCotizacionProveedor(CotizacionProveedor cotizacionProveedor) {
        return jdbcTemplate
                .update("update cotizacion_proveedor set id_cotizacion_cliente = ?, fecha_cotizacion = ? where id_cotizacion_proveedor = ?",
                        cotizacionProveedor.getIdCotizacionCliente(), cotizacionProveedor.getFechaCotizacion(), cotizacionProveedor.getIdCotizacionProveedor());
    }

    public int deleteCotizacionProveedorClienteById(BigDecimal idCotizacionProveedor) {
        return jdbcTemplate
                .update("delete cotizacion_proveedor where id_cotizacion_proveedor = ?", idCotizacionProveedor);
    }

    public List<CotizacionProveedor> findAll() {
        return jdbcTemplate
                .query("select * from cotizacion_proveedor",
                        (rs, rowNum) ->
                                new CotizacionProveedor(
                                        rs.getBigDecimal("id_cotizacion_proveedor"),
                                        rs.getBigDecimal("id_cotizacion_cliente"),
                                        rs.getDate("fecha_cotizacion")
                                )
                );
    }

    public Optional<CotizacionProveedor> findCotizacionProveedorById(BigDecimal idCotizacionProveedor) {
        return jdbcTemplate
                .queryForObject("select * from cotizacion_proveedor where id_cotizacion_proveedor = ?",
                        new Object[]{idCotizacionProveedor},
                        (rs, rowNum) ->
                                Optional.of(new CotizacionProveedor(
                                        rs.getBigDecimal("id_cotizacion_proveedor"),
                                        rs.getBigDecimal("id_cotizacion_cliente"),
                                        rs.getDate("fecha_cotizacion")
                                ))
                );
    }*/
}
