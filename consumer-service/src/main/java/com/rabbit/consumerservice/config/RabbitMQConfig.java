package com.rabbit.consumerservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "myQueue";

    @Bean
    public Queue exampleQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}