package co.edu.javeriana.cotizaciones.rabbitmq.controller;

import co.edu.javeriana.cotizaciones.model.Cotizacion;
import co.edu.javeriana.cotizaciones.model.ProductoCotizado;
import co.edu.javeriana.cotizaciones.rabbitmq.service.RabbitMQSender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1.0")
public class RabbitMQWebController {
    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("codigoCotizacion") String codigoCotizacion, @RequestParam("nombreCotizacion") String nombreCotizacion)  {
        Cotizacion cotizacion = new Cotizacion();
        cotizacion.setCodigo(codigoCotizacion);
        final ProductoCotizado productoCotizado = new ProductoCotizado();
        productoCotizado.getProducto().setNombre("Camisa a cuadros");
        productoCotizado.getProducto().setPrecio(1.500);

        cotizacion.getProductosCotizados().add(productoCotizado);
        System.out.println("-- json string after serializing --");
        ObjectMapper om = new ObjectMapper();
        String s = null;

        try {
            s = om.writeValueAsString(cotizacion);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(s);

        rabbitMQSender.send(cotizacion);

        return "Mensaje enviado a RabbitMQ exitosamente!";
    }

}