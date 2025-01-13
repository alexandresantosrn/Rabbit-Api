package com.microservico.estoquepreco.controllers;

import constants.RabbitMQConstants;
import dtos.EstoqueDTO;
import com.microservico.estoquepreco.services.RabbitMQService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {

    private final RabbitMQService rabbitMQService;

    public EstoqueController(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    @PutMapping
    private ResponseEntity editEstoque(@RequestBody EstoqueDTO estoqueDTO) {
        this.rabbitMQService.sendMessage(RabbitMQConstants.FILA_ESTOQUE, estoqueDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
