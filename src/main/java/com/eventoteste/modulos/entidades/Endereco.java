package com.eventoteste.modulos.entidades;

import com.eventoteste.aplicacao.modelo.ClasseModelo;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enderecos")
public class Endereco extends ClasseModelo {

    private String cidade;
    private String uf;
    private String local;

    @OneToOne
    @JoinColumn(name = "eventoUuid")
    private Evento evento;
}