package co.edu.javeriana.cotizaciones.controllers;

import co.edu.javeriana.cotizaciones.dto.Catalogo;
import co.edu.javeriana.cotizaciones.dto.Users;
import co.edu.javeriana.cotizaciones.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Usuarios {
    Logger logger = LoggerFactory.getLogger(Usuarios.class);

    @Autowired
    private UsersRepository repository;

    @PostMapping("/registrarUsuario")
    public String savePage(@ModelAttribute("usuario") Users usuario, Model model) {
        if (usuario != null) {
            logger.info("usuario: {}", usuario);
            repository.crearUsers(usuario);
        }

        return "productos";
    }

}
