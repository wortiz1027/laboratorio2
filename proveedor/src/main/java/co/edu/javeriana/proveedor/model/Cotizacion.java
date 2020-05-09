package co.edu.javeriana.proveedor.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "codigo")
public class Cotizacion implements Serializable {
    private static final long serialVersionUID = -1469181990232546386L;

    private String codigo;
    private Date fechaCreacion;
    private Date fechaRespuesta;
    private List<Producto> productos;

    public List<Producto> getProductos() {
        if (this.productos == null)
            this.productos = new ArrayList<Producto>(0);
        return this.productos;
    }

    @Override
    public String toString() {
        return "Cotizacion{" +
                "codigo='" + codigo + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaRespuesta=" + fechaRespuesta +
                '}';
    }
}
