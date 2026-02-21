package com.eventoteste.modulos.dtos.response;

import com.eventoteste.modulos.dtos.request.UUIDIngresso;
import java.util.List;

public record OLDUsuarioResponse(
        String email,
        String senha,
        boolean ativo,
        boolean criadorEvento,
        List<UUIDIngresso> ingressos
){}
