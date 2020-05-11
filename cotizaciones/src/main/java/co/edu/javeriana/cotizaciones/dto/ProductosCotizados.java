package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;

public class ProductosCotizados {

    private BigDecimal idProductosCotizados;
    private BigDecimal idProducto;
    private BigDecimal idCotizacion;

    public ProductosCotizados() {
    }

    public ProductosCotizados(BigDecimal idProductosCotizados, BigDecimal idProducto, BigDecimal idCotizacion) {
        this.idProductosCotizados = idProductosCotizados;
        this.idProducto = idProducto;
        this.idCotizacion = idCotizacion;
    }

    public BigDecimal getIdProductosCotizados() {
        return idProductosCotizados;
    }

    public void setIdProductosCotizados(BigDecimal idProductosCotizados) {
        this.idProductosCotizados = idProductosCotizados;
    }

    public BigDecimal getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public BigDecimal getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(BigDecimal idCotizacion) {
        this.idCotizacion = idCotizacion;
    }
}
