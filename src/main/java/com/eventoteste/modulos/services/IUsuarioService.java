package com.eventoteste.modulos.services;

import com.eventoteste.aplicacao.Exceptions.UsuarioNaoEncontradoException;
import com.eventoteste.modulos.entidades.Usuario;

import java.util.UUID;

public interface IUsuarioService {
    
    Usuario adicionar (Usuario usuario);
    Usuario buscarPorUuid (UUID uuid) throws UsuarioNaoEncontradoException;
    Usuario atualizar (UUID uuid, Usuario usuario);
    void excluir(UUID uuid);
}
