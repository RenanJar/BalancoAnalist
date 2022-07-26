package com.conectionRabbitMQ.connections;

import com.conectionRabbitMQ.interfaces.ConnectionRabbitmq;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CsvDeleteConnection implements ConnectionRabbitmq {

    @Autowired
    AmqpAdmin amqpAdmin;

    private static final String NOME_EXCHANGE = "amq.direct";

    public static final String FILA_NAME = "csvDelete";

    @Override
    public DirectExchange messageExchange(String nomeExchange) {
        return new DirectExchange(nomeExchange);
    }

    @Override
    public Queue fila() {
        return new Queue(FILA_NAME ,true,false,false);
    }
    @Override
    public Binding relacionamento(Queue fila, DirectExchange trocaObject, String rountingkey) {
        return BindingBuilder.bind(fila).to(trocaObject).with(rountingkey);
    }

    @PostConstruct
    private void declarar(){
        this.amqpAdmin.declareQueue(fila());
        this.amqpAdmin.declareExchange(messageExchange(NOME_EXCHANGE));
        this.amqpAdmin.declareBinding(relacionamento(fila(),messageExchange(NOME_EXCHANGE)
                ,""));
    }
}
