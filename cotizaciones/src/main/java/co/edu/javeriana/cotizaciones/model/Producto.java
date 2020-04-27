package co.edu.javeriana.cotizaciones.model;

public class Producto {
    private String nombre;
    private Double precio;

    public Producto() {
        super();
        this.nombre = "";
        this.precio = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
