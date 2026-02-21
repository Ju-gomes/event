package com.eventoteste.modulos.dtos.response;

import com.eventoteste.modulos.dtos.request.EnderecoRequest;
import com.eventoteste.modulos.entidades.Endereco;
import java.time.LocalDateTime;
import java.util.UUID;

public record EventoResponse (
        UUID uuid,
        String titulo,
        String descricao,
        LocalDateTime data,
        Boolean online,
        int publicoTotal,
//   List<UUIDIngresso> ingressos,
        EnderecoRequest endereco
){}
