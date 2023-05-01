package com.atob.springrabbitmqproducer.producer;

import com.atob.springrabbitmqproducer.data.MessageEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class RabbitMqMessageProducer {

    private RabbitTemplate template;

    public RabbitMqMessageProducer(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping("/sendMessage")
    public void send(@RequestBody MessageEntity message){
        message.setMessageId(UUID.randomUUID().toString());
        message.setDateTime(LocalDateTime.now());
        template.convertAndSend(message);
    }
}
