package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;

public class Catalogo {

    private BigDecimal idCatalogo;
    private BigDecimal idProveedor;
    private String nombreCatalogo;
    private String tipoCatalogo;

    public Catalogo() {
    }

    public Catalogo(BigDecimal idCatalogo, BigDecimal idProveedor, String nombreCatalogo, String tipoCatalogo) {
        this.idCatalogo = idCatalogo;
        this.idProveedor = idProveedor;
        this.nombreCatalogo = nombreCatalogo;
        this.tipoCatalogo = tipoCatalogo;
    }

    public BigDecimal getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(BigDecimal idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public BigDecimal getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(BigDecimal idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreCatalogo() {
        return nombreCatalogo;
    }

    public void setNombreCatalogo(String nombreCatalogo) {
        this.nombreCatalogo = nombreCatalogo;
    }

    public String getTipoCatalogo() {
        return tipoCatalogo;
    }

    public void setTipoCatalogo(String tipoCatalogo) {
        this.tipoCatalogo = tipoCatalogo;
    }
}
