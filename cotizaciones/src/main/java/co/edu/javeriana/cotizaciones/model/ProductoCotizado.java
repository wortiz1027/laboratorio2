package co.edu.javeriana.cotizaciones.model;

public class ProductoCotizado {
    private Producto producto;
    private int cantidad;

    public ProductoCotizado() {
        super();
        this.producto = new Producto();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
