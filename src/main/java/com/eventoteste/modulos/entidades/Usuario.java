package com.eventoteste.modulos.entidades;

import com.eventoteste.aplicacao.modelo.ClasseModelo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "usuarios")
public class Usuario extends ClasseModelo {

//    @Column(unique = true)
    private String email;
    private String senha;
    private boolean ativo = true;
    private boolean criadorEvento = false;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingresso> ingressos = new ArrayList<>();
}