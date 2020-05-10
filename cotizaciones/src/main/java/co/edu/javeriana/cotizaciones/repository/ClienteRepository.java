package co.edu.javeriana.cotizaciones.repository;

import co.edu.javeriana.cotizaciones.dto.Catalogo;
import co.edu.javeriana.cotizaciones.dto.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int crearCliente(Cliente cliente) {
        return jdbcTemplate
                .update("insert into cliente (id_usuario, nombres, apellidos, email, telefono) values (?,?,?,?,?)",
                        cliente.getIdUsuario(), cliente.getNombres(), cliente.getApellidos(), cliente.getEmail(), cliente.getTelefono());
    }

    public int actualizarCliente(Cliente cliente) {
        return jdbcTemplate
                .update("update cliente set id_usuario = ?, nombres = ?, apellidos = ?, email = ?, telefono = ? where id_cliente = ?",
                        cliente.getIdUsuario(), cliente.getNombres(), cliente.getApellidos(), cliente.getEmail(), cliente.getTelefono(), cliente.getIdCliente());
    }

    public int deleteClienteByIdCliente(BigDecimal idCliente) {
        return jdbcTemplate
                .update("delete cliente where id_cliente = ?", idCliente);
    }

    public List<Cliente> findAll() {
        return jdbcTemplate
                .query("select * from cliente",
                        (rs, rowNum) ->
                                new Cliente(
                                        rs.getBigDecimal("id_cliente"),
                                        rs.getBigDecimal("id_usuario"),
                                        rs.getString("nombres"),
                                        rs.getString("apellidos"),
                                        rs.getString("email"),
                                        rs.getString("telefono")
                                )
                );
    }

    public Optional<Cliente> findClienteByIdCliente(BigDecimal idCliente) {
        return jdbcTemplate
                .queryForObject("select * from cliente where id_cliente = ?",
                        new Object[]{idCliente},
                        (rs, rowNum) ->
                                Optional.of(new Cliente(
                                        rs.getBigDecimal("id_cliente"),
                                        rs.getBigDecimal("id_usuario"),
                                        rs.getString("nombres"),
                                        rs.getString("apellidos"),
                                        rs.getString("email"),
                                        rs.getString("telefono"))
                                )
                );
    }
}
