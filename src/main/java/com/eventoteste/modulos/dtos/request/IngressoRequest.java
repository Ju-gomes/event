package com.eventoteste.modulos.dtos.request;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

public record IngressoRequest(
        BigDecimal valor,
        LocalDateTime validade,
        UUIDEvento eventoUuid,
        UUIDUsuario usuarioUuid
) {}