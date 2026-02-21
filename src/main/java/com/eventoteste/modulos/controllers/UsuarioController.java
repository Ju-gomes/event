package com.eventoteste.modulos.controllers;

import com.eventoteste.aplicacao.configuracao.mapper.GenericMapper;
import com.eventoteste.modulos.dtos.request.UsuarioRequest;
import com.eventoteste.modulos.dtos.request.UsuarioRequest;
import com.eventoteste.modulos.dtos.response.UsuarioResponse;
import com.eventoteste.modulos.dtos.response.UsuarioResponse;
import com.eventoteste.modulos.entidades.Usuario;
import com.eventoteste.modulos.services.implementacoes.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Gestão de Usuarios", description = "CRUD")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioServiceImpl service;
    private final GenericMapper mapper;

    public UsuarioController(UsuarioServiceImpl service, GenericMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse adicionar(@RequestBody @Valid UsuarioRequest request){
//        Usuario usuario = mapper.toEntity(request);
        Usuario usuario = mapper.map(request, Usuario.class);
//        return mapper.toResponseDTO(service.adicionar(usuario));
        return mapper.map(service.adicionar(usuario), UsuarioResponse.class);
    }

    @GetMapping("/{usuarioUuid}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse buscarPorUuid(@PathVariable UUID usuarioUuid){
//        return mapper.toResponseDTO(service.buscarPorUuid(usuarioUuid));
        return mapper.map(service.buscarPorUuid(usuarioUuid), UsuarioResponse.class);
    }

    @PutMapping("/{usuarioUuid}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse atualizar(@PathVariable UUID usuarioUuid, @RequestBody @Valid UsuarioRequest request){
//        Usuario usuario = mapper.toEntity(request);
//        return mapper.toResponseDTO(service.atualizar(usuarioUuid, usuario));
        Usuario usuario = mapper.map(request, Usuario.class);
        return mapper.map(service.atualizar(usuarioUuid, usuario), UsuarioResponse.class);
    }

    @DeleteMapping("/{usuarioUuid}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable UUID usuarioUuid){
        service.excluir(usuarioUuid);
    }
}
