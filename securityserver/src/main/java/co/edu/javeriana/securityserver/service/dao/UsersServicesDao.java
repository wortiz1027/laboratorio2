package co.edu.javeriana.securityserver.service.dao;

import co.edu.javeriana.securityserver.model.Roles;
import co.edu.javeriana.securityserver.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersServicesDao {

    void createUser(Users u, List<Roles> role);

    boolean isUserAvailable(String username);

    Users getUserByUsername(String username);

    Users update(Users u);

    void delete(Users u);

}