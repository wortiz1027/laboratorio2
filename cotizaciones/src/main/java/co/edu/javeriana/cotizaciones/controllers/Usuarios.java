package co.edu.javeriana.cotizaciones.controllers;

import co.edu.javeriana.cotizaciones.dto.UserRole;
import co.edu.javeriana.cotizaciones.dto.Users;
import co.edu.javeriana.cotizaciones.repository.RoleRepository;
import co.edu.javeriana.cotizaciones.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class Usuarios {
    Logger logger = LoggerFactory.getLogger(Usuarios.class);

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String securedPage(Model model, Principal principal) {
        Users usuario = new Users();
        model.addAttribute("usuario", usuario);
        return "register";
    }

    @PostMapping("/registrarUsuario")
    public String savePage(@ModelAttribute("usuario") Users usuario, Model model) throws ParseException {
        logger.info("El usuario que esta tratando de ingresarse es: {}", usuario);
        if (usuario != null) {
            logger.info("usuario: {}", usuario);
            usuario.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(usuario.getFechaNacimientoCadena()));

            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

            BigDecimal idUser = userRepository.crearUsers(usuario);
            logger.info("id usuario: {}", idUser);
            UserRole userRole = new UserRole(idUser, usuario.getRole().getIdRole());
            roleRepository.crearRoleUser(userRole);
        }

        return "redirect:/productos";
    }

}
