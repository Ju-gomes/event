package com.eventoteste.modulos.services;

import com.eventoteste.aplicacao.Exceptions.EventoNaoEncontradoException;
import com.eventoteste.modulos.dtos.request.EventoRequest;
import com.eventoteste.modulos.dtos.response.EventoResponse;
import com.eventoteste.modulos.entidades.Evento;
import java.util.UUID;

public interface IEventoService {
    
    Evento adicionar (Evento evento);
    Evento buscarPorUuid (UUID uuid) throws EventoNaoEncontradoException;
    Evento atualizar (UUID uuid, Evento evento);
    void excluir(UUID uuid);
}
