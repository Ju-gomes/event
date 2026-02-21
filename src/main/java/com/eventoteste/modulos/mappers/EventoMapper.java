package com.eventoteste.modulos.mappers;

import com.eventoteste.aplicacao.configuracao.mapper.GenericMapper;
import com.eventoteste.modulos.dtos.request.EventoRequest;
import com.eventoteste.modulos.dtos.response.EventoResponse;
import com.eventoteste.modulos.entidades.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventoMapper {

    private final GenericMapper mapper;

    public EventoMapper(GenericMapper mapper) {
        this.mapper = mapper;
    }

    public Evento toEntity(EventoRequest request) {
        return mapper.map(request, Evento.class);
    }

    public EventoResponse toResponseDTO(Evento evento) {
        return mapper.map(evento, EventoResponse.class);
    }

    public List<EventoResponse> toResponseList(List<Evento> entities) {
        return entities.stream()
                .map(entity -> mapper.map(entity, EventoResponse.class))
                .collect(Collectors.toList());
    }


    // Se precisar atualizar entidade existente (PUT parcial)
    public void updateFromDto(EventoRequest request, Evento entity) {
        mapper.map(request, entity);
    }
}
