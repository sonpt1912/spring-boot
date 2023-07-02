package com.example.be.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    // đăng ký 1 địa chỉ enpoint
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //"/my-websocket-endpoint" là địa chỉ WebSocket endpoint mà client kết nối đến.
        registry.addEndpoint("/my-websocket-endpoint").setAllowedOrigins("http://127.0.0.1:5500").withSockJS();
        //"setAllowedOrigins("http://127.0.0.1:5500")" chỉ cho phép kết nối đến từ domain "http://127.0.0.1:5500"
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // đăng ký các đường đi cho message broker
        // đây là các đường đi mà serve sẽ suwr dụng tin nhắn để gửi đến client
        registry.enableSimpleBroker("/topic", "/queue/");
        registry.setApplicationDestinationPrefixes("/app"); // các message mapping đến serve phải có tiền tố /app
    }
}
