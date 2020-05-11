package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cotizacion {

    private BigDecimal idCotizacion;
    private BigDecimal idUser;
    private List<Producto> productos;
    private Date fechaCotizacion;
    private Date fechaRespuesta;

    public Cotizacion() {
        this.productos = new ArrayList<>();
    }

    public Cotizacion(BigDecimal idCotizacion, BigDecimal idUser, List<Producto> productos, Date fechaCotizacion, Date fechaRespuesta) {
        this.idCotizacion = idCotizacion;
        this.idUser = idUser;
        this.productos = productos;
        this.fechaCotizacion = fechaCotizacion;
        this.fechaRespuesta = fechaRespuesta;
    }

    public BigDecimal getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(BigDecimal idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public BigDecimal getIdUser() {
        return idUser;
    }

    public void setIdUser(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Date getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(Date fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }
}
