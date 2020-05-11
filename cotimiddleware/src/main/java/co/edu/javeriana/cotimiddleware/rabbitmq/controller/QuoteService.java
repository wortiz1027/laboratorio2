package co.edu.javeriana.cotimiddleware.rabbitmq.controller;

import co.edu.javeriana.cotimiddleware.rabbitmq.service.RabbitMQSender;
import co.edu.javeriana.cotimiddleware.model.Cotizacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0")
public class QuoteService {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteService.class);

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Value("${quote.rabbitmq.routingkey.sendquote}")
    String routingkeysendquote;

    @PostMapping(path = "/enviarCotizacion",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> enviarCotizacionesAProveedores(@RequestBody Cotizacion cotizacion) {
        LOG.info("REST enviarCotizacionesAProveedores.cotizacion {}", cotizacion);
        rabbitMQSender.publishQuote(routingkeysendquote, cotizacion);
        return new ResponseEntity<Void> (HttpStatus.OK);
    }
}