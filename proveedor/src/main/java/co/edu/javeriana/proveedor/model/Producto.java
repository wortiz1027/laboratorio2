package co.edu.javeriana.proveedor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto implements Serializable {
    private static final long serialVersionUID = -5898784828558964065L;

    private BigDecimal idProducto;
    private BigDecimal idCatalogo;
    private String nombreProducto;
    private String tipoProducto;
    private String descripcionProducto;
    private List<PrecioProveedor> precios;

    public List<PrecioProveedor> getPrecios() {
        if (this.precios == null)
            this.precios = new ArrayList<PrecioProveedor>(0);
        return this.precios;
    }
}
