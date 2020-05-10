package co.edu.javeriana.proveedor.services;

import co.edu.javeriana.proveedor.controller.CotizacionManagement;
import co.edu.javeriana.proveedor.model.Cotizacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0")
public class CotizacionService {
    private static final Logger LOG = LoggerFactory.getLogger(CotizacionService.class);

    @PostMapping(path = "/cotizaciones",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cotizacion cotizar(@RequestBody Cotizacion cotizacion) {
        LOG.info("REST cotizar.cotizacion {}", cotizacion);
        return CotizacionManagement.generarCotizacionAutomatica(cotizacion);
    }
}
