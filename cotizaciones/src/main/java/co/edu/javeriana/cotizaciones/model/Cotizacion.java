package co.edu.javeriana.cotizaciones.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Cotizacion.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "codigo")
public class Cotizacion {
    private String codigo;
    private List<ProductoCotizado> productosCotizados;

    public Cotizacion() {
        super();
        this.productosCotizados = new ArrayList<ProductoCotizado>(0);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<ProductoCotizado> getProductosCotizados() {
        return productosCotizados;
    }

    public void setProductosCotizados(List<ProductoCotizado> productosCotizados) {
        this.productosCotizados = productosCotizados;
    }
}
