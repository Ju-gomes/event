package com.eventoteste.modulos.mappers;

import com.eventoteste.aplicacao.configuracao.mapper.GenericMapper;
import com.eventoteste.modulos.dtos.request.OLDUsuarioRequest;
import com.eventoteste.modulos.dtos.response.OLDUsuarioResponse;
import com.eventoteste.modulos.entidades.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    private final GenericMapper mapper;

    public UsuarioMapper(GenericMapper mapper) {
        this.mapper = mapper;
    }

    public Usuario toEntity(OLDUsuarioRequest request) {
        return mapper.map(request, Usuario.class);
    }

    public OLDUsuarioResponse toResponseDTO(Usuario usuario) {
        return mapper.map(usuario, OLDUsuarioResponse.class);
    }

    public List<OLDUsuarioResponse> toResponseList(List<Usuario> entities) {
        return entities.stream()
                .map(entity -> mapper.map(entity, OLDUsuarioResponse.class))
                .collect(Collectors.toList());
    }



}
