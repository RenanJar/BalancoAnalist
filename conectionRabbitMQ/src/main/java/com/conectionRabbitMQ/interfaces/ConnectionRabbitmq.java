package com.conectionRabbitMQ.interfaces;

import org.springframework.amqp.core.*;

public interface ConnectionRabbitmq {

    public DirectExchange messageExchange(String nomeExchange);

    public Queue fila ();

    public Binding relacionamento(Queue fila, DirectExchange trocaObject, String rountingkey);



}
