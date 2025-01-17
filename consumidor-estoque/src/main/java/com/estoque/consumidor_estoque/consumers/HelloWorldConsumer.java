package com.estoque.consumidor_estoque.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldConsumer {

    @RabbitListener(queues = "hello_world_queue")
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}
