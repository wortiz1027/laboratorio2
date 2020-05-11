package co.edu.javeriana.cotimiddleware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrecioProveedor implements Serializable {
    private static final long serialVersionUID = -2584379966293959020L;

    private BigDecimal idPrecioProveedor;
    private BigDecimal idUser;
    private BigDecimal idProducto;
    private BigDecimal precio;
}
