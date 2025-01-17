package com.estoque.consumidor_estoque.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.RabbitMQConstants;
import dtos.EstoqueDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

//    @RabbitListener(queues = RabbitMQConstants.FILA_ESTOQUE)
//    private void consumer(String msg) throws JsonProcessingException {
//        EstoqueDTO estoqueDTO = new ObjectMapper().readValue(msg, EstoqueDTO.class);
//
//        System.out.println(estoqueDTO.productCode);
//        System.out.println(estoqueDTO.quantity);
//        System.out.println("------------------------------------");
//    }
}
