package com.eventoteste.aplicacao.Exceptions;

public class EventoNaoEncontradoException extends RuntimeException {
    public EventoNaoEncontradoException(String message) {
        super(message);
    }
}
