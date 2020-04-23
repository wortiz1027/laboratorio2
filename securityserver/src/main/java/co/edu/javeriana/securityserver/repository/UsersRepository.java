package co.edu.javeriana.securityserver.repository;

import co.edu.javeriana.securityserver.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    @Query("SELECT count(u) FROM Users u WHERE u.username = :ipUsername")
    int isUserAvailable(@Param("ipUsername") String ipUsername);

    @Query("SELECT u FROM Users u WHERE u.username = :ipUsername")
    Users loadUserByUsername(@Param("ipUsername") String username);

    //void delete(BigDecimal idUser);
}
