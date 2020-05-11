package co.edu.javeriana.cotizaciones.repository;

import co.edu.javeriana.cotizaciones.dto.Cotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class CotizacionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int crearCotizacion(Cotizacion cotizacion) {
        return jdbcTemplate
                .update("insert into cotizacion (id_user, fecha_cotizacion, fecha_respuesta) values (?,?,?)",
                        cotizacion.getIdUser(), cotizacion.getFechaCotizacion(), cotizacion.getFechaRespuesta());
    }

    public int actualizarCotizacion(Cotizacion cotizacion) {
        return jdbcTemplate
                .update("update cotizacion set id_user = ?, fecha_cotizacion = ?, fecha_respuesta = ? where id_cotizacion = ?",
                        cotizacion.getIdUser(), cotizacion.getFechaCotizacion(), cotizacion.getFechaRespuesta(), cotizacion.getIdCotizacion());
    }

    public int deleteCotizacionById(BigDecimal idCotizacion) {
        return jdbcTemplate
                .update("delete cotizacion where id_cotizacion = ?", idCotizacion);
    }

    public List<Cotizacion> findAll() {
        return jdbcTemplate
                .query("select * from cotizacion",
                        (rs, rowNum) ->
                                new Cotizacion(
                                        rs.getBigDecimal("id_cotizacion"),
                                        rs.getBigDecimal("id_user"),
                                        null,
                                        rs.getDate("fecha_cotizacion"),
                                        rs.getDate("fecha_respuesta")
                                )
                );
    }

    public Optional<Cotizacion> findCotizacionById(BigDecimal idCotizacion) {
        return jdbcTemplate
                .queryForObject("select * from cotizacion where id_cotizacion = ?",
                        new Object[]{idCotizacion},
                        (rs, rowNum) ->
                                Optional.of(new Cotizacion(
                                        rs.getBigDecimal("id_cotizacion"),
                                        rs.getBigDecimal("id_user"),
                                        null,
                                        rs.getDate("fecha_cotizacion"),
                                        rs.getDate("fecha_respuesta")
                                ))
                );
    }
}
