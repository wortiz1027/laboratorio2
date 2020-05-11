package co.edu.javeriana.cotizaciones.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductosWrapper {

    private List<List<Producto>> productos = new ArrayList<>();

    public List<List<Producto>> getProductos() {
        return productos;
    }

    public void setProductos(List<List<Producto>> productos) {
        this.productos = productos;
    }
}
