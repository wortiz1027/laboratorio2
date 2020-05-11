package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;

public class WrapperProducto {

    private Producto producto;
    private BigDecimal precio;

    public WrapperProducto() {
    }

    public WrapperProducto(Producto producto, BigDecimal precio) {
        this.producto = producto;
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
