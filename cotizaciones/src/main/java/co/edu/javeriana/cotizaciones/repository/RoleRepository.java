package co.edu.javeriana.cotizaciones.repository;

import co.edu.javeriana.cotizaciones.dto.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int crearRoleUser(UserRole userRole) {
        return jdbcTemplate
                .update("insert into users_roles (user_id, role_id) values (?,?)",
                        userRole.getIdUser(), userRole.getIdRole());
    }

}
