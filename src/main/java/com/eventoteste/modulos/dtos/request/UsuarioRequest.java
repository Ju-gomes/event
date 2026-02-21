package com.eventoteste.modulos.dtos.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class UsuarioRequest{

    private String email;
    private String senha;
    private boolean ativo;
    private boolean criadorEvento;
    private List<UUIDIngresso> ingressos;
}
