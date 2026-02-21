package com.eventoteste.modulos.dtos.response;

import com.eventoteste.modulos.dtos.request.UUIDEvento;
import com.eventoteste.modulos.dtos.request.UUIDUsuario;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;

public record IngressoResponse(
        UUID uuid,
        BigDecimal valor,
        LocalDateTime validade,
        UUIDEvento evento,
        UUIDUsuario usuario

) {}
