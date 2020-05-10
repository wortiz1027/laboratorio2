package co.edu.javeriana.cotimiddleware.rabbitmq.listener;

import co.edu.javeriana.cotimiddleware.model.Cotizacion;
import co.edu.javeriana.cotimiddleware.rabbitmq.service.RabbitMQSender;
import co.edu.javeriana.cotimiddleware.utils.ObjectAndByteCovertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QuoteMessageListener {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteMessageListener.class);

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Value("${quote.rabbitmq.exchange}")
    String exchange;

    @Value("${quote.rabbitmq.routingkey.getquote}")
    String routingkeygetquote;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${quote.rabbitmq.queue.sendquotes}"),
            exchange = @Exchange(value = "${quote.rabbitmq.exchange}"),
            key = "${quote.rabbitmq.routingkey.sendquote}"
    ))
    public void validarCotizacionesProveedores(Message message) {
        LOG.info("Method.validarCotizacionesProveedores.Received {}", message);
        Cotizacion cotizacion = (Cotizacion) ObjectAndByteCovertUtil.ByteToObject(message.getBody());
        //Invocar al proveedor 1

        //Invocar al proveedor 2

        LOG.info("Method.validarCotizacionesProveedores.Publishing...........");
        rabbitMQSender.publishQuote(routingkeygetquote, cotizacion);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${quote.rabbitmq.queue.getquote}"),
            exchange = @Exchange(value = "${quote.rabbitmq.exchange}"),
            key = "${quote.rabbitmq.routingkey.getquote}"
    ))
    public void checkamounttopay(Message message) {
        LOG.info("Method.checkamounttopay.Received {}", message);
        Cotizacion cotizacion = (Cotizacion) ObjectAndByteCovertUtil.ByteToObject(message.getBody());
        //Invocar al sistema de cotización
        LOG.info("Method.checkamounttopay.Publishing...........");
    }
}
