package com.eventoteste.modulos.controllers;

import com.eventoteste.modulos.dtos.request.EventoRequest;
import com.eventoteste.modulos.dtos.request.IngressoRequest;
import com.eventoteste.modulos.dtos.response.EventoResponse;
import com.eventoteste.modulos.dtos.response.IngressoResponse;
import com.eventoteste.modulos.entidades.Evento;
import com.eventoteste.modulos.entidades.Ingresso;
import com.eventoteste.modulos.mappers.EventoMapper;
import com.eventoteste.modulos.services.implementacoes.EventoServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Gestão de Eventos", description = "CRUD")
@RestController
@RequestMapping("/")
public class EventoController {

    private final EventoServiceImpl service;
    private final EventoMapper mapper;

    public EventoController(EventoServiceImpl service, EventoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventoResponse adicionar(@RequestBody @Valid EventoRequest request){
        Evento evento = mapper.toEntity(request);
        return mapper.toResponseDTO(service.adicionar(evento));
    }

    @GetMapping("/{eventoUuid}")
    @ResponseStatus(HttpStatus.OK)
    public EventoResponse buscarPorUuid(@PathVariable UUID eventoUuid){
        return mapper.toResponseDTO(service.buscarPorUuid(eventoUuid));
    }

    @PutMapping("/{ingressoUuid}/ingresso")
    @ResponseStatus(HttpStatus.OK)
    public EventoResponse atualizar(@PathVariable UUID eventoUuid, @RequestBody @Valid EventoRequest request){
        Evento evento = mapper.toEntity(request);
        return mapper.toResponseDTO(service.atualizar(eventoUuid, evento));
    }

    @DeleteMapping("/deletar/{ingressoUuid}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable UUID eventoUuid){
        service.excluir(eventoUuid);
    }



}
