package co.edu.javeriana.cotizaciones.repository;

import co.edu.javeriana.cotizaciones.dto.PrecioProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class PrecioProveedorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*public int crearProducto(PrecioProveedor producto) {
        return jdbcTemplate
                .update("insert into producto (id_catalogo, nombre_producto, descripcion_producto, tipo_producto) values (?,?,?,?)",
                        producto.getIdCatalogo(), producto.getNombreProducto(), producto.getDescripcionProducto(), producto.getTipoProducto());
    }

    public int actualizarProducto(PrecioProveedor producto) {
        return jdbcTemplate
                .update("update producto set id_catalogo = ?, nombre_producto = ?, descripcion_producto = ?, tipo_producto = ? where id_producto = ?",
                        producto.getIdCatalogo(), producto.getNombreProducto(), producto.getTipoProducto(), producto.getTipoProducto(), producto.getIdProducto());
    }

    public int deleteProductoById(BigDecimal idProducto) {
        return jdbcTemplate
                .update("delete from producto where id_producto = ?", idProducto);
    }

    public List<PrecioProveedor> findAll() {
        return jdbcTemplate
                .query("select * from producto",
                        (rs, rowNum) ->
                                new PrecioProveedor(
                                        rs.getBigDecimal("id_producto"),
                                        rs.getBigDecimal("id_catalogo"),
                                        rs.getString("nombre_producto"),
                                        rs.getString("descripcion_producto"),
                                        rs.getString("tipo_producto"),
                                        null
                                )
                );
    }

    public Optional<PrecioProveedor> findPrecioProveedorById(BigDecimal idProducto) {
        return jdbcTemplate
                .queryForObject("select * from precio_proveedor where id_producto = ?",
                        new Object[]{idProducto},
                        (rs, rowNum) ->
                                Optional.of(new PrecioProveedor(
                                                rs.getBigDecimal("id_producto"),
                                                rs.getBigDecimal("id_catalogo"),
                                                rs.getString("nombre_producto"),
                                                rs.getString("descripcion_producto"),
                                                rs.getString("tipo_producto"),
                                        null
                                        )
                                )
                );
    }*/

}
