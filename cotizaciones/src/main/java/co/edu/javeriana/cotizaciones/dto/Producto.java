package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;

public class Producto {

    private BigDecimal idProducto;
    private BigDecimal idCatalogo;
    private String nombreProducto;
    private BigDecimal precio;
    private String tipoProducto;

    public Producto() {
    }

    public Producto(BigDecimal idProducto, BigDecimal idCatalogo, String nombreProducto, BigDecimal precio, String tipoProducto) {
        this.idProducto = idProducto;
        this.idCatalogo = idCatalogo;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }

    public BigDecimal getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public BigDecimal getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(BigDecimal idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
