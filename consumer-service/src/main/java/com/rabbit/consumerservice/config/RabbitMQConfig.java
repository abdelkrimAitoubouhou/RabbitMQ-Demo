package com.rabbit.consumerservice.config;

import com.rabbit.consumerservice.service.EmailService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private final EmailService emailService;


    public RabbitMQConfig(EmailService emailService) {
        this.emailService = emailService;
    }


    public static final String QUEUE_NAME = "myQueue";


    @Bean
    public Queue exampleQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void listen(String message) {
        System.out.println("Received message: " + message);

        // Send email when message is received
        emailService.sendEmail(
                "aitoubouhouhafid@gmail.com",
                "Rabbit msg",   // Email Subject
                message                   // Email Body (Message from RabbitMQ)
        );

    }
}