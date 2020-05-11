package co.edu.javeriana.cotimiddleware.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCotizacion")
public class Cotizacion implements Serializable {
    private static final long serialVersionUID = 4081004502608822827L;

    private BigDecimal idCotizacion;
    private BigDecimal idUser;
    private List<Producto> productos;
    private Date fechaCotizacion;
    private Date fechaRespuesta;
}
