package co.edu.javeriana.securityserver.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "roles", schema = "securitydb")
public class Roles implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @NotNull
    @Column(name = "ID_ROLE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal idRole;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ROLE")
    private String role;

    @JoinTable(name = "USERS_ROLES", joinColumns = {
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID_ROLE")}, inverseJoinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "ID_USER")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Users> userList;

    public Roles() {
    }

    public Roles(BigDecimal idRole) {
        this.idRole = idRole;
    }

    public Roles(BigDecimal idRole, String role) {
        this.idRole = idRole;
        this.role = role;
    }

    public BigDecimal getIdRole() {
        return idRole;
    }

    public void setIdRole(BigDecimal idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Users> getUserList() {
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Role[ idRole=" + idRole + " ]";
    }
}
