package com.eventoteste.modulos.entidades;

import com.eventoteste.aplicacao.modelo.ClasseModelo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eventos")
public class Evento extends ClasseModelo {

    private String titulo;
    private String descricao;
    private LocalDateTime data;
    private Boolean online;
    private int publicoTotal;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true, fetch =  FetchType.LAZY)
    private List<Ingresso> ingressos = new ArrayList<>();

    @OneToOne(mappedBy = "evento", cascade = CascadeType.ALL)
    private Endereco endereco;



}
