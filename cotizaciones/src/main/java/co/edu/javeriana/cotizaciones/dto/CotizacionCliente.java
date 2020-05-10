package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CotizacionCliente {

    private BigDecimal idCotizacionCliente;
    private BigDecimal idCliente;
    private BigDecimal idCotizacionProveedor;
    private Date fechaCotizacion;

    public CotizacionCliente() {
    }

    public CotizacionCliente(BigDecimal idCotizacionCliente, BigDecimal idCliente, BigDecimal idCotizacionProveedor, Date fechaCotizacion) {
        this.idCotizacionCliente = idCotizacionCliente;
        this.idCliente = idCliente;
        this.idCotizacionProveedor = idCotizacionProveedor;
        this.fechaCotizacion = fechaCotizacion;
    }

    public BigDecimal getIdCotizacionCliente() {
        return idCotizacionCliente;
    }

    public void setIdCotizacionCliente(BigDecimal idCotizacionCliente) {
        this.idCotizacionCliente = idCotizacionCliente;
    }

    public BigDecimal getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigDecimal idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getIdCotizacionProveedor() {
        return idCotizacionProveedor;
    }

    public void setIdCotizacionProveedor(BigDecimal idCotizacionProveedor) {
        this.idCotizacionProveedor = idCotizacionProveedor;
    }

    public Date getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(Date fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }
}
