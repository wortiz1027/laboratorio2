package co.edu.javeriana.cotimiddleware.rabbitmq.service;

import co.edu.javeriana.cotimiddleware.model.Cotizacion;
import co.edu.javeriana.cotimiddleware.rabbitmq.config.RabbitMQConnection;
import co.edu.javeriana.cotimiddleware.utils.ObjectAndByteCovertUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    private static final Logger LOG = LoggerFactory.getLogger(RabbitMQSender.class);

    @Value("${quote.rabbitmq.exchange}")
    private String exchange;

    public void publishQuote(String routingKey, Cotizacion cotizacion) {
        LOG.info("Method.publishQuote routingKey {} and {}", routingKey, cotizacion);

        try {
            Connection conn = RabbitMQConnection.getConnection();

            if (conn != null) {
                Channel channel = conn.createChannel();
                // First message sent by using routingKey
                channel.basicPublish(exchange, routingKey, new AMQP.BasicProperties.Builder().contentType(MediaType.APPLICATION_JSON_VALUE).build(), ObjectAndByteCovertUtil.ObjectToByte(cotizacion));
                LOG.info(" Message Sent {}", cotizacion);

                channel.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
