package co.edu.javeriana.cotizaciones.repository;

import co.edu.javeriana.cotizaciones.dto.Catalogo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public class CatalogoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int crearCatalogo(Catalogo catalogo) {
        return jdbcTemplate
                .update("insert into catalogo (id_user, nombre_catalogo, tipo_catalogo, descripcion_catalogo) values (?,?,?,?)",
                        catalogo.getIdUser(), catalogo.getNombreCatalogo(), catalogo.getTipoCatalogo(), catalogo.getDescripcionCatalogo());
    }

    public int actualizarCatalogo(Catalogo catalogo) {
        return jdbcTemplate
                .update("update catalogo set id_user = ?, nombre_catalogo = ?, tipo_catalogo = ?, descripcion_catalogo = ? where id_catalogo = ?",
                        catalogo.getIdUser(), catalogo.getNombreCatalogo(), catalogo.getTipoCatalogo(), catalogo.getDescripcionCatalogo(), catalogo.getIdCatalogo());
    }

    public int deleteCatalogoByIdCatalogo(BigDecimal idCatalogo) {
        return jdbcTemplate
                .update("delete catalogo where id_catalogo = ?", idCatalogo);
    }

    public List<Catalogo> findAll() {
        return jdbcTemplate
                .query("select * from catalogo",
                        (rs, rowNum) ->
                                new Catalogo(
                                        rs.getBigDecimal("id_catalogo"),
                                        rs.getBigDecimal("id_user"),
                                        rs.getString("nombre_catalogo"),
                                        rs.getString("tipo_catalogo"),
                                        rs.getString("descripcion_catalogo")
                                )
                );
    }

    public Optional<Catalogo> findCatalogoByIdCatalogo(BigDecimal idCatalogo) {
        return jdbcTemplate
                .queryForObject("select * from catalogo where id_catalogo = ?",
                        new Object[]{idCatalogo},
                        (rs, rowNum) ->
                                Optional.of(new Catalogo(
                                        rs.getBigDecimal("id_catalogo"),
                                        rs.getBigDecimal("id_user"),
                                        rs.getString("nombre_catalogo"),
                                        rs.getString("tipo_catalogo"),
                                        rs.getString("descripcion_catalogo")
                                ))
                );
    }

    public List<Catalogo> findCatalogoByIdUser(BigDecimal idUser) {
        return jdbcTemplate
                .query("select * from catalogo where id_user = ?",
                        new Object[]{idUser},
                        (rs, rowNum) ->
                                new Catalogo(
                                        rs.getBigDecimal("id_catalogo"),
                                        rs.getBigDecimal("id_user"),
                                        rs.getString("nombre_catalogo"),
                                        rs.getString("tipo_catalogo"),
                                        rs.getString("descripcion_catalogo")
                                )
                );
    }
}
