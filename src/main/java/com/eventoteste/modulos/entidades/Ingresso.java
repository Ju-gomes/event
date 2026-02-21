package com.eventoteste.modulos.entidades;

import com.eventoteste.aplicacao.modelo.ClasseModelo;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ingressos",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = { "codigo", "eventoUuid"})}
)
public class Ingresso extends ClasseModelo {

    @Column(name = "codigo", updatable = false, unique = true)
    private UUID codigo;

    private BigDecimal valor;
    private LocalDateTime validade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventoUuid")
    private Evento evento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioUuid")
    private Usuario usuario;

}
