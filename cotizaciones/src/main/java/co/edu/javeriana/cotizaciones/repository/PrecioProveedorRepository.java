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

    public int crearPrecioProveedor(PrecioProveedor precioProveedor) {
        return jdbcTemplate
                .update("insert into precio_proveedor (id_user, id_producto, precio) values (?,?,?)",
                        precioProveedor.getIdUser(), precioProveedor.getIdProducto(), precioProveedor.getPrecio());
    }

    public int actualizarProducto(PrecioProveedor precioProveedor) {
        return jdbcTemplate
                .update("update precio_proveedor set id_user = ?, id_producto = ?, precio = ? where id_precio_proveedor = ?",
                        precioProveedor.getIdUser(), precioProveedor.getIdProducto(), precioProveedor.getPrecio(), precioProveedor.getIdPrecioProveedor());
    }

    public int deletePrecioProveedorById(BigDecimal idPrecioProveedor) {
        return jdbcTemplate
                .update("delete from precio_proveedor where id_precio_proveedor = ?", idPrecioProveedor);
    }

    public List<PrecioProveedor> findAll() {
        return jdbcTemplate
                .query("select * from precio_proveedor",
                        (rs, rowNum) ->
                                new PrecioProveedor(
                                        rs.getBigDecimal("id_precio_proveedor"),
                                        rs.getBigDecimal("id_user"),
                                        rs.getBigDecimal("id_producto"),
                                        rs.getBigDecimal("precio")
                                )
                );
    }

    public Optional<PrecioProveedor> findPrecioProveedorById(BigDecimal idPrecioProveedor) {
        return jdbcTemplate
                .queryForObject("select * from precio_proveedor where id_precio_proveedor = ?",
                        new Object[]{idPrecioProveedor},
                        (rs, rowNum) ->
                                Optional.of(new PrecioProveedor(
                                                rs.getBigDecimal("id_precio_proveedor"),
                                                rs.getBigDecimal("id_user"),
                                                rs.getBigDecimal("id_producto"),
                                                rs.getBigDecimal("precio")
                                        )
                                )
                );
    }

}
