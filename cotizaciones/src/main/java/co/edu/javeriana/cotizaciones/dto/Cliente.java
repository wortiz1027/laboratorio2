package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;

public class Cliente {

    private BigDecimal idCliente;
    private BigDecimal idUsuario;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;

    public Cliente() {
    }

    public Cliente(BigDecimal idCliente, BigDecimal idUsuario, String nombres, String apellidos, String email, String telefono) {
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }

    public BigDecimal getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigDecimal idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
