package co.edu.javeriana.securityserver.service.dao;

import co.edu.javeriana.securityserver.model.Roles;

import java.util.List;

public interface RoleServicesDao {

    List<Roles> getAllRoles();

    Roles getInfoRole();

    void deleteRole();

    void updateRole();


}
