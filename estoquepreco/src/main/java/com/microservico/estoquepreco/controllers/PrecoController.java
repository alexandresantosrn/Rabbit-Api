package com.microservico.estoquepreco.controllers;

import constants.RabbitMQConstants;
import dtos.PrecoDTO;
import com.microservico.estoquepreco.services.RabbitMQService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "preco")
public class PrecoController {

    private final RabbitMQService rabbitMQService;

    public PrecoController(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    @PutMapping
    private ResponseEntity editPrice (@RequestBody PrecoDTO priceDTO) {
        this.rabbitMQService.sendMessage(RabbitMQConstants.FILA_PRECO, priceDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
