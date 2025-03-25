package com.rabbit.producerservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "myQueue";
    public static final String EXCHANGE = "myExchange";
    public static final String ROUTING_KEY = "routing_key";


    // this bean allows to create new queue named "firstQueue"
    @Bean
    public Queue createQueue() {
        return new Queue(QUEUE, true);
    }

    // this bean allows to create new exchange named "myExchange"
    @Bean
    public DirectExchange createExchange() {
        return new DirectExchange(EXCHANGE);
    }


    // this bean allows to bind the queue with the exchange by a routing_key
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

}