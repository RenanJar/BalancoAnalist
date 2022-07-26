package com.conectionRabbitMQ.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MessageDTO implements Serializable {

    String mensagem;

    public MessageDTO() {
    }

    public MessageDTO(String mensagem) {
        this.mensagem = mensagem;
    }
}
