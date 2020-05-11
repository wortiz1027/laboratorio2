package co.edu.javeriana.cotizaciones.repository;

import co.edu.javeriana.cotizaciones.controllers.Usuarios;
import co.edu.javeriana.cotizaciones.dto.Role;
import co.edu.javeriana.cotizaciones.dto.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepository {
    Logger logger = LoggerFactory.getLogger(UsersRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BigDecimal crearUsers(Users users) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("insert into users (cedula, nombres, apellidos, direccion, fecha_nacimiento, telefono, email, username, password, enable, account_non_expired, credential_non_expired, account_non_locket) values (?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setBigDecimal(1, users.getCedula());
            ps.setString(2, users.getNombres());
            ps.setString(3, users.getApellidos());
            ps.setString(4, users.getDireccion());
            ps.setDate(5, new java.sql.Date(users.getFechaNacimiento().getTime()));
            ps.setBigDecimal(6, users.getTelefono());
            ps.setString(7, users.getEmail());
            ps.setString(8, users.getUsername());
            ps.setString(9, users.getPassword());
            ps.setString(10, "true");
            ps.setString(11, "true");
            ps.setString(12, "true");
            ps.setString(13, "true");
            return ps;
        }, keyHolder);


       /* return jdbcTemplate
                .update("insert into users (cedula, nombres, apellidos, direccion, fecha_nacimiento, telefono, email, username, password, enable, account_non_expired, credential_non_expired, account_non_locket) values (?,?,?,?,?,?,?,?,?,?,?,?,?)",
                        users.getCedula(), users.getNombres(), users.getApellidos(), users.getDireccion(), users.getFechaNacimiento(), users.getTelefono(), users.getEmail(), users.getUsername(), users.getPassword(), Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    */
        logger.info("Llave de respuesta: {}", keyHolder.getKey());
        logger.info("Llave de class: {}", keyHolder.getKey().getClass().getName());
        return new BigDecimal(((BigInteger) keyHolder.getKey()).intValue());
    }

    public int actualizarUsers(Users users) {
        return jdbcTemplate
                .update("update producto set cedula = ?, nombres = ?, apellidos = ?, direccion = ?, fecha_nacimiento = ?, telefono = ?, email = ?, username = ?, password = ?, enable = ?, account_non_expired = ?, credential_non_expired = ?, account_non_locket = ? where id_user = ?",
                        users.getCedula(), users.getNombres(), users.getApellidos(), users.getDireccion(), users.getFechaNacimiento(), users.getTelefono(), users.getEmail(), users.getUsername(), users.getPassword(), users.getEnable(), users.getAccountNonExpired(), users.getCredentialNonExpired(), users.getAccountNonLocket(), users.getIdUser());
    }

    public int deleteUsersById(BigDecimal idUsers) {
        return jdbcTemplate
                .update("delete from users where id_user = ?", idUsers);
    }

    public List<Users> findAll() {
        return jdbcTemplate
                .query("select * from users",
                        (rs, rowNum) ->
                                new Users(
                                        rs.getBigDecimal("id_user"),
                                        rs.getBigDecimal("cedula"),
                                        rs.getString("nombres"),
                                        rs.getString("apellidos"),
                                        rs.getString("direccion"),
                                        null,
                                        rs.getDate("fecha_nacimiento"),
                                        rs.getBigDecimal("telefono"),
                                        rs.getString("email"),
                                        rs.getString("username"),
                                        rs.getString("password"),
                                        rs.getString("enable"),
                                        rs.getString("account_non_expired"),
                                        rs.getString("credential_non_expired"),
                                        rs.getString("account_non_locket"),
                                        new Role()
                                )
                );
    }

    public Optional<Users> findUsersById(BigDecimal idUser) {
        return jdbcTemplate
                .queryForObject("select * from users where id_user = ?",
                        new Object[]{idUser},
                        (rs, rowNum) ->
                                Optional.of(new Users(
                                                rs.getBigDecimal("id_user"),
                                                rs.getBigDecimal("cedula"),
                                                rs.getString("nombres"),
                                                rs.getString("apellidos"),
                                                rs.getString("direccion"),
                                        null,
                                                rs.getDate("fecha_nacimiento"),
                                                rs.getBigDecimal("telefono"),
                                                rs.getString("email"),
                                                rs.getString("username"),
                                                rs.getString("password"),
                                                rs.getString("enable"),
                                                rs.getString("account_non_expired"),
                                                rs.getString("credential_non_expired"),
                                                rs.getString("account_non_locket"),
                                                new Role()
                                        )
                                )
                );
    }

    public Optional<Users> findUsersByUserName(String username) {
        return jdbcTemplate
                .queryForObject("select * from users where username = ?",
                        new Object[]{username},
                        (rs, rowNum) ->
                                Optional.of(new Users(
                                                rs.getBigDecimal("id_user"),
                                                rs.getBigDecimal("cedula"),
                                                rs.getString("nombres"),
                                                rs.getString("apellidos"),
                                                rs.getString("direccion"),
                                        null,
                                                rs.getDate("fecha_nacimiento"),
                                                rs.getBigDecimal("telefono"),
                                                rs.getString("email"),
                                                rs.getString("username"),
                                                rs.getString("password"),
                                                rs.getString("enable"),
                                                rs.getString("account_non_expired"),
                                                rs.getString("credential_non_expired"),
                                                rs.getString("account_non_locket"),
                                                new Role()
                                        )
                                )
                );
    }

}
