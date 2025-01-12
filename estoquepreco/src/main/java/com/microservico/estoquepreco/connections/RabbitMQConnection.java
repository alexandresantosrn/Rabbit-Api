package com.microservico.estoquepreco.connections;

import com.microservico.estoquepreco.constants.RabbitMQConstants;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection {

    /* Nome da Exchange da listagem de exchanges do RabbitMQ. */
    private static final String NAME_EXCHANGE = "amq.direct";

    private final AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String queueName) {
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange directExchange() {
        return new DirectExchange(NAME_EXCHANGE);
    }

    private Binding relationship(Queue queue, DirectExchange change) {
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, change.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void add() {
        Queue filaEstoque = this.queue(RabbitMQConstants.FILA_ESTOQUE);
        Queue filaPreco = this.queue(RabbitMQConstants.FILA_PRECO);

        DirectExchange change = this.directExchange();

        Binding bindingEstoque = this.relationship(filaEstoque, change);
        Binding bindingPreco = this.relationship(filaPreco, change);

        /* Criando as filas. */
        this.amqpAdmin.declareQueue(filaEstoque);
        this.amqpAdmin.declareQueue(filaPreco);

        /* Criando as exchanges. */
        this.amqpAdmin.declareExchange(change);

        /* Criando os bindings. */
        this.amqpAdmin.declareBinding(bindingEstoque);
        this.amqpAdmin.declareBinding(bindingPreco);
    }
}
