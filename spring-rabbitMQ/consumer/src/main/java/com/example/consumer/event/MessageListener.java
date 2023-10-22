package com.example.consumer.event;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    private static final String QUEUE = "queue_demo";

    @RabbitListener(queues = QUEUE)
    public void listener(MessageListener messageListener) {
        System.out.println("-> " + messageListener);
    }

}
