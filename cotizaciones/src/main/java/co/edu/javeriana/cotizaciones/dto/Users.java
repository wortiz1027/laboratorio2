package co.edu.javeriana.cotizaciones.dto;

import java.math.BigDecimal;
import java.util.Date;

public class Users {

    private BigDecimal idUser;
    private BigDecimal cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String fechaNacimientoCadena;
    private Date fechaNacimiento;
    private BigDecimal telefono;
    private String email;
    private String username;
    private String password;
    private String enable;
    private String accountNonExpired;
    private String credentialNonExpired;
    private String accountNonLocket;
    private Role role;

    public Users() {
        this.role = new Role();
    }

    public Users(BigDecimal idUser, BigDecimal cedula, String nombres, String apellidos, String direccion, String fechaNacimientoCadena, Date fechaNacimiento, BigDecimal telefono, String email, String username, String password, String enable, String accountNonExpired, String credentialNonExpired, String accountNonLocket, Role role) {
        this.idUser = idUser;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fechaNacimientoCadena = fechaNacimientoCadena;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.accountNonExpired = accountNonExpired;
        this.credentialNonExpired = credentialNonExpired;
        this.accountNonLocket = accountNonLocket;
        this.role = role;
    }

    public BigDecimal getIdUser() {
        return idUser;
    }

    public void setIdUser(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public BigDecimal getCedula() {
        return cedula;
    }

    public void setCedula(BigDecimal cedula) {
        this.cedula = cedula;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public BigDecimal getTelefono() {
        return telefono;
    }

    public void setTelefono(BigDecimal telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(String accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public String getCredentialNonExpired() {
        return credentialNonExpired;
    }

    public void setCredentialNonExpired(String credentialNonExpired) {
        this.credentialNonExpired = credentialNonExpired;
    }

    public String getAccountNonLocket() {
        return accountNonLocket;
    }

    public void setAccountNonLocket(String accountNonLocket) {
        this.accountNonLocket = accountNonLocket;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFechaNacimientoCadena() {
        return fechaNacimientoCadena;
    }

    public void setFechaNacimientoCadena(String fechaNacimientoCadena) {
        this.fechaNacimientoCadena = fechaNacimientoCadena;
    }
}
