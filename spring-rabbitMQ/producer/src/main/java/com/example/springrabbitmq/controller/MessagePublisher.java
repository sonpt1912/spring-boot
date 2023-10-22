package com.example.springrabbitmq.controller;

import com.example.springrabbitmq.dto.CustomMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/rabbitmq")
@Log4j2
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody CustomMessage customMessage) {
        customMessage.setMessageId(UUID.randomUUID().toString());
        customMessage.setMessageDate(new Date());

        log.info(exchange + " " + routingKey + " " + customMessage.getMessageId());


        template.convertAndSend(exchange, routingKey, customMessage);
        return "Message publish";
    }


}
