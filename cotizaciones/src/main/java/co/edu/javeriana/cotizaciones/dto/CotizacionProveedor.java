package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CotizacionProveedor {

    private BigDecimal idCotizacionProveedor;
    private BigDecimal idCotizacionCliente;
    private Date fechaCotizacion;

    public CotizacionProveedor() {
    }

    public CotizacionProveedor(BigDecimal idCotizacionProveedor, BigDecimal idCotizacionCliente, Date fechaCotizacion) {
        this.idCotizacionProveedor = idCotizacionProveedor;
        this.idCotizacionCliente = idCotizacionCliente;
        this.fechaCotizacion = fechaCotizacion;
    }

    public BigDecimal getIdCotizacionProveedor() {
        return idCotizacionProveedor;
    }

    public void setIdCotizacionProveedor(BigDecimal idCotizacionProveedor) {
        this.idCotizacionProveedor = idCotizacionProveedor;
    }

    public BigDecimal getIdCotizacionCliente() {
        return idCotizacionCliente;
    }

    public void setIdCotizacionCliente(BigDecimal idCotizacionCliente) {
        this.idCotizacionCliente = idCotizacionCliente;
    }

    public Date getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(Date fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }
}
