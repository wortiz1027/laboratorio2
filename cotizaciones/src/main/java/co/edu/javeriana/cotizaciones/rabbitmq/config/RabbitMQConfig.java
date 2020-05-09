package co.edu.javeriana.cotizaciones.rabbitmq.config;

//import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${custom.rabbitmq.queue}")
    String queueName;

    @Value("${custom.rabbitmq.exchange}")
    String exchange;

    @Value("${custom.rabbitmq.routingkey}")
    private String routingkey;

    @Bean
    Queue queue() {
        System.out.println("Metodo: queue()");
        return new Queue(queueName, false);
    }

    @Bean
    DirectExchange exchange() {
        System.out.println("Metodo: exchange()");
        return new DirectExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        System.out.println("Metodo: binding(Queue queue, DirectExchange exchange)");
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        System.out.println("Metodo: jsonMessageConverter()");
        return new Jackson2JsonMessageConverter();
    }

    /*
    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        System.out.println("Metodo: rabbitTemplate(ConnectionFactory connectionFactory)");
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
    */

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        System.out.println("Metodo: rabbitTemplate(ConnectionFactory connectionFactory)");
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}