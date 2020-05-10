package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;

public class Proveedor {

    private BigDecimal idProveedor;
    private BigDecimal idUsuario;
    private String nombreProveedor;
    private String identificacionProveedor;
    private String telefonoProveedor;

    public Proveedor() {
    }

    public Proveedor(BigDecimal idProveedor, BigDecimal idUsuario, String nombreProveedor, String identificacionProveedor, String telefonoProveedor) {
        this.idProveedor = idProveedor;
        this.idUsuario = idUsuario;
        this.nombreProveedor = nombreProveedor;
        this.identificacionProveedor = identificacionProveedor;
        this.telefonoProveedor = telefonoProveedor;
    }

    public BigDecimal getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(BigDecimal idProveedor) {
        this.idProveedor = idProveedor;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getIdentificacionProveedor() {
        return identificacionProveedor;
    }

    public void setIdentificacionProveedor(String identificacionProveedor) {
        this.identificacionProveedor = identificacionProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }
}
