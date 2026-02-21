package com.eventoteste.modulos.dtos.request;


import com.eventoteste.modulos.entidades.Endereco;
import com.eventoteste.modulos.entidades.Ingresso;

import java.time.LocalDateTime;
import java.util.List;

public record EventoRequest(
        String titulo,
        String descricao,
        LocalDateTime data,
        Boolean online,
        int publicoTotal,
//        List<Ingresso> ingressos,
        EnderecoRequest endereco
){}
