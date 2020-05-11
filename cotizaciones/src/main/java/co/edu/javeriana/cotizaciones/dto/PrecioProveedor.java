package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;

public class PrecioProveedor {

    private BigDecimal idPrecioProveedor;
    private BigDecimal idUser;
    private BigDecimal idProducto;
    private BigDecimal precio;

    public PrecioProveedor() {
    }

    public PrecioProveedor(BigDecimal idPrecioProveedor, BigDecimal idUser, BigDecimal idProducto, BigDecimal precio) {
        this.idPrecioProveedor = idPrecioProveedor;
        this.idUser = idUser;
        this.idProducto = idProducto;
        this.precio = precio;
    }

    public BigDecimal getIdPrecioProveedor() {
        return idPrecioProveedor;
    }

    public void setIdPrecioProveedor(BigDecimal idPrecioProveedor) {
        this.idPrecioProveedor = idPrecioProveedor;
    }

    public BigDecimal getIdUser() {
        return idUser;
    }

    public void setIdUser(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public BigDecimal getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
