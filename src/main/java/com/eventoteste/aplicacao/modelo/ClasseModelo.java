package com.eventoteste.aplicacao.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;

@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class ClasseModelo {

    @Id
    @UuidGenerator     // @GenericGenerator depreciado
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "timestamp with time zone")
    private OffsetDateTime dataCriacao;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "timestamp with time zone")
    private OffsetDateTime dataUltimaModificacao;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean inativo = Boolean.FALSE;

}
