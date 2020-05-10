package co.edu.javeriana.proveedor.controller;

import co.edu.javeriana.proveedor.model.Cotizacion;
import co.edu.javeriana.proveedor.services.CotizacionManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0")
public class CotizacionService {
    private static final Logger LOG = LoggerFactory.getLogger(CotizacionService.class);

    /*@GetMapping("/cotizaciones/{nombre}")
    public ResponseEntity<String> saludo(@PathVariable("nombre") String nombre) {
        return new ResponseEntity<String>("Hola mundo " + nombre, HttpStatus.OK);
    }*/

    @PostMapping(path = "/cotizaciones",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cotizacion cotizar(@RequestBody Cotizacion cotizacion) {
        LOG.info("REST cotizar.cotizacion {}", cotizacion);

        return CotizacionManagement.generarCotizacionAutomatica(cotizacion);
    }
}
