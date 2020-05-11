package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;

public class Catalogo {

    private BigDecimal idCatalogo;
    private BigDecimal idUser;
    private String nombreCatalogo;
    private String tipoCatalogo;
    private String descripcionCatalogo;

    public Catalogo() {
    }

    public Catalogo(BigDecimal idCatalogo, BigDecimal idUser, String nombreCatalogo, String tipoCatalogo, String descripcionCatalogo) {
        this.idCatalogo = idCatalogo;
        this.idUser = idUser;
        this.nombreCatalogo = nombreCatalogo;
        this.tipoCatalogo = tipoCatalogo;
        this.descripcionCatalogo = descripcionCatalogo;
    }

    public BigDecimal getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(BigDecimal idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public BigDecimal getIdUser() {
        return idUser;
    }

    public void setIdUser(BigDecimal idUser) {
        this.idUser = idUser;
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

    public String getDescripcionCatalogo() {
        return descripcionCatalogo;
    }

    public void setDescripcionCatalogo(String descripcionCatalogo) {
        this.descripcionCatalogo = descripcionCatalogo;
    }
}
