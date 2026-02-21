package com.eventoteste.aplicacao.Exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }
}
