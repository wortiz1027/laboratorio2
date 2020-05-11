package co.edu.javeriana.cotizaciones.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1.0")
public class Cotizacion {

    @PostMapping("/cotizaciones/precios")
    public ResponseEntity<String> cotizaciones(@RequestBody(required = true)co.edu.javeriana.cotizaciones.dto.Cotizacion cotizacion){



        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
