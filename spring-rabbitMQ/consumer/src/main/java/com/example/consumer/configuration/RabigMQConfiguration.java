package com.example.consumer.configuration;

import com.rabbitmq.client.RpcServer;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabigMQConfiguration {

    @Value("${rpc.queue.name}")
    private String rpcQueueName;

    @Value("${rpc.reply.queue.name}")
    private String rpcReplyQueueName;

    @Bean
    public Queue rpcQueue() {
        return new Queue(rpcQueueName);
    }

    @Bean
    public Queue rpcReplyQueue() {
        return new Queue(rpcReplyQueueName);
    }

    @Bean
    public SimpleMessageListenerContainer rpcListenerContainer(ConnectionFactory connectionFactory,
                                                               MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(rpcQueueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(RpcServer rpcServer) {
        return new MessageListenerAdapter(rpcServer, new Jackson2JsonMessageConverter());
    }

    @Bean
    public RpcServer rpcServer(FibonacciService fibonacciService) {
        return new RpcServer(fibonacciService);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setExchange("");
        template.setRoutingKey(rpcQueueName);
        template.setUseTemporaryReplyQueues(rpcReplyQueue());
        template.setReplyTimeout(60000); // Đặt một thời gian chờ (theo mili giây) cho việc đợi phản hồi
        return template;
    }

}
