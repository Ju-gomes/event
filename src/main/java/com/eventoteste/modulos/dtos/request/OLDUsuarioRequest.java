package com.eventoteste.modulos.dtos.request;

import java.util.List;

public record OLDUsuarioRequest(
        String email,
        String senha,
        boolean ativo,
        boolean criadorEvento,
        List<UUIDIngresso> ingressos
){}
