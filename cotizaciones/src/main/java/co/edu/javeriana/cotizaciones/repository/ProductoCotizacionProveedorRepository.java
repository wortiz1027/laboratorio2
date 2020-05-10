package co.edu.javeriana.cotizaciones.repository;

import co.edu.javeriana.cotizaciones.dto.ProductoCotizacionProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoCotizacionProveedorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int crearProductoCotizacionProveedor(ProductoCotizacionProveedor productoCotizacionProveedor) {
        return jdbcTemplate
                .update("insert into producto_cotizacion_proveedor (id_catalogo, id_producto) values (?,?)",
                        productoCotizacionProveedor.getIdCatalogo(), productoCotizacionProveedor.getIdProducto());
    }

    public int actualizarProductoCotizacionProveedor(ProductoCotizacionProveedor productoCotizacionProveedor) {
        return jdbcTemplate
                .update("update producto_cotizacion_proveedor set id_catalogo = ?, id_producto = ? where id_producto_cotizacion_proveedor = ?",
                        productoCotizacionProveedor.getIdCatalogo(), productoCotizacionProveedor.getIdProducto(), productoCotizacionProveedor.getIdProductoCotizacionProveedor());
    }

    public int deleteProductoCotizacionProveedorById(BigDecimal idProductoCotizacionProveedor) {
        return jdbcTemplate
                .update("delete producto_cotizacion_proveedor where id_producto_cotizacion_proveedor = ?", idProductoCotizacionProveedor);
    }

    public List<ProductoCotizacionProveedor> findAll() {
        return jdbcTemplate
                .query("select * from producto_cotizacion_proveedor",
                        (rs, rowNum) ->
                                new ProductoCotizacionProveedor(
                                        rs.getBigDecimal("id_producto_cotizacion_proveedor"),
                                        rs.getBigDecimal("id_catalogo"),
                                        rs.getBigDecimal("id_producto")
                                )
                );
    }

    public Optional<ProductoCotizacionProveedor> findProductoCotizacionProveedorById(BigDecimal idProductoCotizacionProveedor) {
        return jdbcTemplate
                .queryForObject("select * from producto_cotizacion_proveedor where id_producto_cotizacion_proveedor = ?",
                        new Object[]{idProductoCotizacionProveedor},
                        (rs, rowNum) ->
                                Optional.of(new ProductoCotizacionProveedor(
                                        rs.getBigDecimal("id_producto_cotizacion_proveedor"),
                                        rs.getBigDecimal("id_catalogo"),
                                        rs.getBigDecimal("id_producto"))
                                )
                );
    }

}
