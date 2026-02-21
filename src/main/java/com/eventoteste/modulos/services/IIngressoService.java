package com.eventoteste.modulos.services;

import com.eventoteste.aplicacao.Exceptions.EventoNaoEncontradoException;
import com.eventoteste.aplicacao.Exceptions.IngressoNaoEncontradoException;
import com.eventoteste.modulos.entidades.Evento;
import com.eventoteste.modulos.entidades.Ingresso;

import java.util.UUID;

public interface IIngressoService {
    
    Ingresso adicionar (Ingresso ingresso);
    Ingresso buscarPorUuid (UUID uuid) throws IngressoNaoEncontradoException;
    Ingresso atualizar (UUID uuid, Ingresso ingresso);
    void excluir(UUID uuid);
}
