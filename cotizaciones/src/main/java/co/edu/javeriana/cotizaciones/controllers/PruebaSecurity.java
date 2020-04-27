package co.edu.javeriana.cotizaciones.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PruebaSecurity {

    @GetMapping(value = "/api/v1.0/saludos")
    public Map<String, String> saludos() {
        HashMap<String, String> result = new HashMap<>();
        result.put("Hola", "Mundo");
        return result;
    }

    @GetMapping(value = "/saludos")
    public Map<String, String> anon() {
        HashMap<String, String> result = new HashMap<>();
        result.put("Hola", "Anon");
        return result;
    }

}
