package co.edu.javeriana.cotimiddleware.rabbitmq.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class QuoteAppConfig {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteAppConfig.class);

    @Value("${quote.rabbitmq.exchange}")
    String exchange;

    @Value("${quote.rabbitmq.queue.sendquotes}")
    String queuesendquote;
    @Value("${quote.rabbitmq.routingkey.sendquote}")
    String routingkeysendquote;

    @Value("${quote.rabbitmq.queue.getquote}")
    String queuegetquote;
    @Value("${quote.rabbitmq.routingkey.getquote}")
    String routingkeygetquote;


    @Bean
    public void createExchangeAndQueue(){
        try{
            Connection conn = RabbitMQConnection.getConnection();

            if(conn != null){
                Channel channel = conn.createChannel();
                channel.exchangeDeclare(exchange, "direct", true);

                // Queuesendquote Queue
                channel.queueDeclare(queuesendquote, true, false, false, null);
                channel.queueBind(queuesendquote, exchange, routingkeysendquote);

                // Queuegetquote Queue
                channel.queueDeclare(queuegetquote, true, false, false, null);
                channel.queueBind(queuegetquote, exchange, routingkeygetquote);

                channel.close();
                conn.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
