package co.edu.javeriana.cotizaciones.repository;

import co.edu.javeriana.cotizaciones.dto.Catalogo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CatalogoRepository {

    int crearCatalogo(Catalogo catalogo);

    int actualizarCatalogo(Catalogo catalogo);

    int deleteCatalogoByIdCatalogo(BigDecimal idCatalogo);

    List<Catalogo> findAll();

    Optional<Catalogo> findCatalogoByIdCatalogo(BigDecimal idCatalogo);
}
