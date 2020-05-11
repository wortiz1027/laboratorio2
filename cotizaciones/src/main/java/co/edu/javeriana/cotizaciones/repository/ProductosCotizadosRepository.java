package co.edu.javeriana.cotizaciones.repository;

import co.edu.javeriana.cotizaciones.dto.ProductosCotizados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductosCotizadosRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int crearProductosCotizados(ProductosCotizados productosCotizados) {
        return jdbcTemplate
                .update("insert into productos_cotizados (id_producto, id_cotizacion) values (?,?)",
                        productosCotizados.getIdProducto(), productosCotizados.getIdCotizacion());
    }

    public int actualizarProductosCotizados(ProductosCotizados productosCotizados) {
        return jdbcTemplate
                .update("update productos_cotizados set id_producto = ?, id_cotizacion = ? where id_productos_cotizados = ?",
                        productosCotizados.getIdProducto(), productosCotizados.getIdCotizacion(), productosCotizados.getIdProductosCotizados());
    }

    public int deleteProductosCotizadosById(BigDecimal idProductosCotizados) {
        return jdbcTemplate
                .update("delete from productos_cotizados where id_productos_cotizados = ?", idProductosCotizados);
    }

    public List<ProductosCotizados> findAll() {
        return jdbcTemplate
                .query("select * from productos_cotizados",
                        (rs, rowNum) ->
                                new ProductosCotizados(
                                        rs.getBigDecimal("id_productos_cotizados"),
                                        rs.getBigDecimal("id_producto"),
                                        rs.getBigDecimal("id_cotizacion")
                                )
                );
    }

    public Optional<ProductosCotizados> findProductosCotizadosById(BigDecimal idProductosCotizados) {
        return jdbcTemplate
                .queryForObject("select * from productos_cotizados where id_productos_cotizados = ?",
                        new Object[]{idProductosCotizados},
                        (rs, rowNum) ->
                                Optional.of(new ProductosCotizados(
                                                rs.getBigDecimal("id_productos_cotizados"),
                                                rs.getBigDecimal("id_producto"),
                                                rs.getBigDecimal("id_cotizacion")
                                        )
                                )
                );
    }

}
