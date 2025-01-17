package com.microservico.estoquepreco.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldProducer {

    private final RabbitTemplate rabbitTemplate;

    public HelloWorldProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/send")
    public String sendHelloWorldMessage() {
        String message = "Hello World!";
        rabbitTemplate.convertAndSend("hello_world_queue", message);
        return "Mensagem enviada: " + message;
    }
}
