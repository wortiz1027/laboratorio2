package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;

public class ProductoCotizacionProveedor {

    private BigDecimal idProductoCotizacionProveedor;
    private BigDecimal idCatalogo;
    private BigDecimal idProducto;

    public ProductoCotizacionProveedor() {
    }

    public ProductoCotizacionProveedor(BigDecimal idProductoCotizacionProveedor, BigDecimal idCatalogo, BigDecimal idProducto) {
        this.idProductoCotizacionProveedor = idProductoCotizacionProveedor;
        this.idCatalogo = idCatalogo;
        this.idProducto = idProducto;
    }

    public BigDecimal getIdProductoCotizacionProveedor() {
        return idProductoCotizacionProveedor;
    }

    public void setIdProductoCotizacionProveedor(BigDecimal idProductoCotizacionProveedor) {
        this.idProductoCotizacionProveedor = idProductoCotizacionProveedor;
    }

    public BigDecimal getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(BigDecimal idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public BigDecimal getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }
}
