package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;

public class Role {
    private BigDecimal idRole;

    public Role() {
    }

    public Role(BigDecimal idRole) {
        this.idRole = idRole;
    }

    public BigDecimal getIdRole() {
        return idRole;
    }

    public void setIdRole(BigDecimal idRole) {
        this.idRole = idRole;
    }
}
