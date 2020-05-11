package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;
import java.util.List;

public class Producto {

    private BigDecimal idProducto;
    private BigDecimal idCatalogo;
    private String nombreProducto;
    private String tipoProducto;
    private String descripcionProducto;
    private List<PrecioProveedor> precios;

    public Producto() {
    }

    public Producto(BigDecimal idProducto, BigDecimal idCatalogo, String nombreProducto, String tipoProducto, String descripcionProducto, List<PrecioProveedor> precios) {
        this.idProducto = idProducto;
        this.idCatalogo = idCatalogo;
        this.nombreProducto = nombreProducto;
        this.tipoProducto = tipoProducto;
        this.descripcionProducto = descripcionProducto;
        this.precios = precios;
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

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public List<PrecioProveedor> getPrecios() {
        return precios;
    }

    public void setPrecios(List<PrecioProveedor> precios) {
        this.precios = precios;
    }
}
