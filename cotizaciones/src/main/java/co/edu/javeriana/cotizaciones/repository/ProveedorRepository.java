package co.edu.javeriana.cotizaciones.repository;

import co.edu.javeriana.cotizaciones.dto.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class ProveedorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int crearProveedor(Proveedor proveedor) {
        return jdbcTemplate
                .update("insert into proveedor (id_usuario, nombre_proveedor, identificacion_proveedor, telefono_proveedor) values (?,?,?,?)",
                        proveedor.getIdUsuario(), proveedor.getNombreProveedor(), proveedor.getIdentificacionProveedor(), proveedor.getTelefonoProveedor());
    }

    public int actualizarProveedor(Proveedor proveedor) {
        return jdbcTemplate
                .update("update proveedor set id_usuario = ?, nombre_proveedor = ?, identificacion_proveedor = ?, telefono_proveedor = ? where id_proveedor = ?",
                        proveedor.getIdUsuario(), proveedor.getNombreProveedor(), proveedor.getIdentificacionProveedor(), proveedor.getTelefonoProveedor(), proveedor.getIdProveedor());
    }

    public int deleteProveedorById(BigDecimal idProveedor) {
        return jdbcTemplate
                .update("delete proveedor where id_proveedor = ?", idProveedor);
    }

    public List<Proveedor> findAll() {
        return jdbcTemplate
                .query("select * from proveedor",
                        (rs, rowNum) ->
                                new Proveedor(
                                        rs.getBigDecimal("id_proveedor"),
                                        rs.getBigDecimal("id_usuario"),
                                        rs.getString("nombre_proveedor"),
                                        rs.getString("identificacion_proveedor"),
                                        rs.getString("telefono_proveedor")
                                )
                );
    }

    public Optional<Proveedor> findProveedorById(BigDecimal idProveedor) {
        return jdbcTemplate
                .queryForObject("select * from proveedor where id_proveedor = ?",
                        new Object[]{idProveedor},
                        (rs, rowNum) ->
                                Optional.of(new Proveedor(
                                                rs.getBigDecimal("id_proveedor"),
                                                rs.getBigDecimal("id_usuario"),
                                                rs.getString("nombre_proveedor"),
                                                rs.getString("identificacion_proveedor"),
                                                rs.getString("telefono_proveedor")
                                        )
                                )
                );
    }
}
