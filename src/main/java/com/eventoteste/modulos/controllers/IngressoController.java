package com.eventoteste.modulos.controllers;

import com.eventoteste.modulos.dtos.request.IngressoRequest;
import com.eventoteste.modulos.dtos.response.IngressoResponse;
import com.eventoteste.modulos.entidades.Evento;
import com.eventoteste.modulos.entidades.Ingresso;
import com.eventoteste.modulos.mappers.EventoMapper;
import com.eventoteste.modulos.mappers.IngressoMapper;
import com.eventoteste.modulos.services.implementacoes.IngressoServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Gestão de Ingressos", description = "CRUD")
@RestController
@RequestMapping("/ingresso")
public class IngressoController {

    private final IngressoServiceImpl service;
    private final IngressoMapper mapper;

    public IngressoController(IngressoServiceImpl service, IngressoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IngressoResponse adicionar(@RequestBody @Valid IngressoRequest request){
        Ingresso ingresso = mapper.toEntity(request);
        return mapper.toResponseDTO(service.adicionar(ingresso));
    }

    @GetMapping("/{ingressoUuid}")
    @ResponseStatus(HttpStatus.OK)
    public IngressoResponse buscarPorUuid(@PathVariable UUID ingressoUuid){
        return mapper.toResponseDTO(service.buscarPorUuid(ingressoUuid));
    }

    @PutMapping("/{ingressoUuid}/ingresso")
    @ResponseStatus(HttpStatus.OK)
    public IngressoResponse atualizar(@PathVariable UUID ingressoUuid, @RequestBody @Valid IngressoRequest request){
        Ingresso ingresso = mapper.toEntity(request);
        return mapper.toResponseDTO(service.atualizar(ingressoUuid, ingresso));
    }

    @DeleteMapping("/{ingressoUuid}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable UUID ingressoUuid){
        service.excluir(ingressoUuid);
    }
}
