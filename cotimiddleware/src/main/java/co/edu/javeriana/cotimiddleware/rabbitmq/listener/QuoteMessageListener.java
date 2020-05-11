package co.edu.javeriana.cotimiddleware.rabbitmq.listener;

import co.edu.javeriana.cotimiddleware.model.Cotizacion;
import co.edu.javeriana.cotimiddleware.rabbitmq.service.RabbitMQSender;
import co.edu.javeriana.cotimiddleware.utils.ObjectAndByteCovertUtil;
import co.edu.javeriana.cotimiddleware.utils.QuoteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuoteMessageListener {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteMessageListener.class);

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${quote.rabbitmq.exchange}")
    String exchange;

    @Value("${quote.rabbitmq.routingkey.getquote}")
    String routingkeygetquote;

    @Value("${providers.providerA}")
    String providerA;

    @Value("${providers.providerB}")
    String providerB;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${quote.rabbitmq.queue.sendquotes}"),
            exchange = @Exchange(value = "${quote.rabbitmq.exchange}"),
            key = "${quote.rabbitmq.routingkey.sendquote}"
    ))
    public void validarCotizacionesProveedores(Message message) {
        LOG.info("Method.validarCotizacionesProveedores.Received {}", message);
        final Cotizacion cotizacion = (Cotizacion) ObjectAndByteCovertUtil.ByteToObject(message.getBody());
        //Invocar al proveedor 1
        final String urlProveedor1 = "http://localhost:8083/proveedor/api/v1.0/cotizaciones";
        final HttpEntity<Cotizacion> requestEntityresponseProveedor1 = QuoteUtil.encapsulateRequet(cotizacion);
        ResponseEntity<Cotizacion> responseProveedor1 = restTemplate.exchange(urlProveedor1, HttpMethod.POST, requestEntityresponseProveedor1, Cotizacion.class);
        LOG.info("Method.validarCotizacionesProveedores.Received {}", message);
        final Cotizacion cotizacionRs1 = responseProveedor1.getBody();
        QuoteUtil.asignarProveedor(cotizacionRs1, providerA);

        //Invocar al proveedor 2
        final String urlProveedor2 = "http://localhost:8084/proveedor/api/v1.0/cotizaciones";
        final HttpEntity<Cotizacion> requestEntityresponseProveedor2 = QuoteUtil.encapsulateRequet(cotizacion);
        ResponseEntity<Cotizacion> responseresponseProveedor2 = restTemplate.exchange(urlProveedor1, HttpMethod.POST, requestEntityresponseProveedor2, Cotizacion.class);
        LOG.info("Method.validarCotizacionesProveedores.Received {}", message);
        final Cotizacion cotizacionRs2 = responseresponseProveedor2.getBody();
        QuoteUtil.asignarProveedor(cotizacionRs1, providerB);

        //Construimos una lista de cotizaciones con los precios entregados por cada uno de los proveedores
        List<Cotizacion> cotizaciones = new ArrayList<Cotizacion>(0);
        cotizaciones.add(cotizacionRs1);
        cotizaciones.add(cotizacionRs2);

        LOG.info("Method.validarCotizacionesProveedores.Publishing...........");
        rabbitMQSender.publishQuoteWithPrices(routingkeygetquote, cotizaciones);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${quote.rabbitmq.queue.getquote}"),
            exchange = @Exchange(value = "${quote.rabbitmq.exchange}"),
            key = "${quote.rabbitmq.routingkey.getquote}"
    ))
    public void obtenerResultadoCotizacionProveedores(Message message) {
        LOG.info("Method.obtenerResultadoCotizacionProveedores.Received {}", message);
        List<Cotizacion> cotizaciones = (List<Cotizacion>) ObjectAndByteCovertUtil.ByteToObject(message.getBody());
        //TODO Invocar al sistema de cotización
        final String urlSistemaCotizacion = "http://localhost:8082/cotizaciones/api/v1.0/cotizaciones/precios";
        final HttpEntity<List<Cotizacion>> requestEntityresponseCotizaciones = QuoteUtil.encapsulateRequet(cotizaciones);
        restTemplate.exchange(urlSistemaCotizacion, HttpMethod.POST, requestEntityresponseCotizaciones, List.class);
        LOG.info("Method.checkamounttopay.Publishing...........");
    }
}
