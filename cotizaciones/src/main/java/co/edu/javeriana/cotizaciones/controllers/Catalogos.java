package co.edu.javeriana.cotizaciones.controllers;

import co.edu.javeriana.cotizaciones.dto.Catalogo;
import co.edu.javeriana.cotizaciones.dto.Users;
import co.edu.javeriana.cotizaciones.repository.CatalogoRepository;
import co.edu.javeriana.cotizaciones.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class Catalogos {

    Logger logger = LoggerFactory.getLogger(Catalogos.class);

    @Autowired
    private CatalogoRepository catalogoRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/catalogos")
    public String securedPage(Model model, Principal principal) {
        Catalogo catalogo = new Catalogo();

        model.addAttribute("catalogo", catalogo);

        return "catalogos";
    }

    @PostMapping("/registrarCatalogo")
    public String savePage(@ModelAttribute("catalogo") Catalogo catalogo, Model model, Principal principal) {

        Users usuario = usersRepository.findUsersByUserName(principal.getName()).orElseThrow();


        logger.info("usuario id: {}", usuario.getIdUser());
        catalogo.setIdUser(usuario.getIdUser());

        if(catalogo != null){
            logger.info("catalogo: {}", catalogo.getNombreCatalogo());
            catalogoRepository.crearCatalogo(catalogo);
        }

        return "successPage";
    }

}
