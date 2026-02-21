package com.eventoteste.modulos.mappers;

import com.eventoteste.aplicacao.configuracao.mapper.GenericMapper;
import com.eventoteste.modulos.dtos.request.IngressoRequest;
import com.eventoteste.modulos.dtos.response.IngressoResponse;
import com.eventoteste.modulos.entidades.Ingresso;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IngressoMapper {

    private final GenericMapper mapper;

    public IngressoMapper(GenericMapper mapper) {
        this.mapper = mapper;
    }

    public Ingresso toEntity(IngressoRequest request) {
        return mapper.map(request, Ingresso.class);
    }

    public IngressoResponse toResponseDTO(Ingresso ingresso) {
        return mapper.map(ingresso, IngressoResponse.class);
    }

    public List<IngressoResponse> toResponseList(List<Ingresso> entities) {
        return entities.stream()
                .map(entity -> mapper.map(entity, IngressoResponse.class))
                .collect(Collectors.toList());
    }

}
