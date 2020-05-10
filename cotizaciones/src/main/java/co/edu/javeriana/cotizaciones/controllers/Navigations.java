package co.edu.javeriana.cotizaciones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class Navigations {

    @RequestMapping("/charts")
    public String securedPage(Model model, Principal principal) {
        return "charts";
    }

}
