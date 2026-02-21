package com.eventoteste.modulos.repositories;

import com.eventoteste.modulos.entidades.Evento;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventoRepository extends JpaRepository<Evento, UUID>{

}
