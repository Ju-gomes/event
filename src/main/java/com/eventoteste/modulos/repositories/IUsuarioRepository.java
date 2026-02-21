package com.eventoteste.modulos.repositories;

import com.eventoteste.modulos.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, UUID> {
    
}
