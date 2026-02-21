package com.eventoteste.modulos.services.implementacoes;

import com.eventoteste.aplicacao.Exceptions.EventoNaoEncontradoException;
import com.eventoteste.modulos.dtos.response.EventoResponse;
import com.eventoteste.modulos.entidades.Evento;
import com.eventoteste.modulos.mappers.EventoMapper;
import com.eventoteste.modulos.repositories.IEventoRepository;
import com.eventoteste.modulos.services.IEventoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventoServiceImpl implements IEventoService {
       
    private IEventoRepository repository;
    private EventoMapper mapper;

    public EventoServiceImpl(IEventoRepository repository, EventoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Evento adicionar(Evento evento) {
        return  repository.save(evento);

    }

    @Override
    public Evento buscarPorUuid(UUID id) {
        return repository.findById(id).orElseThrow(() -> new EventoNaoEncontradoException("Evento não encontrado"));
    }

    public List<EventoResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public Evento atualizar(UUID uuid, Evento evento) {
        Evento eventoAtualizado = buscarPorUuid(uuid);
        mapper.toResponseDTO(evento);
        return repository.saveAndFlush(eventoAtualizado);
    }

    @Override
    public void excluir(UUID uuid) {
        repository.delete(buscarPorUuid(uuid));
    }
}
