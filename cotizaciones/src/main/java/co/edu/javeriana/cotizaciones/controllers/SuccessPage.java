package co.edu.javeriana.cotizaciones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SuccessPage {

    @GetMapping("/successPage")
    public String securedPage(Model model, Principal principal) {


        return "successPage";
    }

}
