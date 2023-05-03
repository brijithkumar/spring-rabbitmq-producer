package com.atob.springrabbitmqproducer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "spring.rabbitmq")
@Component
@Data
public class RabbitMQProperties {

    private String host;
    private int port;
    private String userName;
    private String password;

}
