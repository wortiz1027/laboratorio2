package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;

public class UserRole {
    private BigDecimal idUser;
    private BigDecimal idRole;

    public UserRole() {
    }

    public UserRole(BigDecimal idUser, BigDecimal idRole) {
        this.idUser = idUser;
        this.idRole = idRole;
    }

    public BigDecimal getIdUser() {
        return idUser;
    }

    public void setIdUser(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public BigDecimal getIdRole() {
        return idRole;
    }

    public void setIdRole(BigDecimal idRole) {
        this.idRole = idRole;
    }
}
