package co.edu.javeriana.cotizaciones.repository;

import co.edu.javeriana.cotizaciones.dto.Catalogo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class CatalogoRepositoryImpl implements CatalogoRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public int crearCatalogo(Catalogo catalogo) {
        return jdbcTemplate
                .update("insert into catalogo (id_proveedor, nombre_catalogo, tipo_catalogo) values (?,?,?)",
                        catalogo.getIdProveedor(), catalogo.getNombreCatalogo(), catalogo.getTipoCatalogo());
    }

    @Override
    public int actualizarCatalogo(Catalogo catalogo) {
        return jdbcTemplate
                .update("update catalogo set id_proveedor = ?, nombre_catalogo = ?, tipo_catalogo = ? where id_catalogo = ?",
                        catalogo.getIdProveedor(), catalogo.getNombreCatalogo(), catalogo.getTipoCatalogo(), catalogo.getIdCatalogo());
    }

    @Override
    public int deleteCatalogoByIdCatalogo(BigDecimal idCatalogo) {
        return jdbcTemplate
                .update("delete catalogo where id_catalogo = ?", idCatalogo);
    }

    @Override
    public List<Catalogo> findAll() {
        return jdbcTemplate
                .query("select * from catalogo",
                        (rs, rowNum) ->
                                new Catalogo(
                                        rs.getBigDecimal("idCatalogo"),
                                        rs.getBigDecimal("idProveedor"),
                                        rs.getString("nombreCatalogo"),
                                        rs.getString("tipoCatalogo")
                                )
                );
    }

    @Override
    public Optional<Catalogo> findCatalogoByIdCatalogo(BigDecimal idCatalogo) {
        return jdbcTemplate
                .queryForObject("select * from catalogo where id_catalogo = ?",
                        new Object[]{idCatalogo},
                        (rs, rowNum) ->
                                Optional.of(new Catalogo(
                                        rs.getBigDecimal("idCatalogo"),
                                        rs.getBigDecimal("idProveedor"),
                                        rs.getString("nombreCatalogo"),
                                        rs.getString("tipoCatalogo"))
                                )
                );
    }
}
