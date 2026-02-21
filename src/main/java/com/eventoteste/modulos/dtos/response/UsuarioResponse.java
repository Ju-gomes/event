package com.eventoteste.modulos.dtos.response;

import com.eventoteste.modulos.dtos.request.UUIDIngresso;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class UsuarioResponse{

    private String email;
    private String senha;
    private boolean ativo;
    private boolean criadorEvento;
    private List<UUIDIngresso> ingressos;
}
