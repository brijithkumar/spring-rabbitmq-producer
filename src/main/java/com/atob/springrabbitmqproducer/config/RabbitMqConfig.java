package com.atob.springrabbitmqproducer.config;

import com.atob.springrabbitmqproducer.utility.MessageConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue queue(){
        return new Queue(MessageConstants.MESSAGE_QUEUE);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(MessageConstants.MESSAGE_EXCHANGE);
    }

    @Bean
    public Binding bind(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange).with(MessageConstants.MESSAGE_ROUTING_KEY);
    }

    @Bean
    public RabbitTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(MessageConstants.MESSAGE_EXCHANGE);
        rabbitTemplate.setRoutingKey(MessageConstants.MESSAGE_ROUTING_KEY);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
