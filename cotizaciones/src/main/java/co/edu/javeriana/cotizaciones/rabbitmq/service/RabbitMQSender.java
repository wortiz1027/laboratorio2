package co.edu.javeriana.cotizaciones.rabbitmq.service;

import co.edu.javeriana.cotizaciones.model.Cotizacion;
//import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RabbitMQSender {
    private static final Logger log = LoggerFactory.getLogger(RabbitMQSender.class);

    @Autowired
    //private AmqpTemplate rabbitTemplate;
    private RabbitTemplate rabbitTemplate;

    @Value("${javecoti.rabbitmq.exchange}")
    private String exchange;

    @Value("${javecoti.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Cotizacion cotizacion) {
        rabbitTemplate.convertAndSend(exchange, routingkey, cotizacion);
        log.info("Enviar mensaje = " + cotizacion);
    }
}
