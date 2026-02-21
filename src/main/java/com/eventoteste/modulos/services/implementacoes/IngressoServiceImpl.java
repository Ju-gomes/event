package com.eventoteste.modulos.services.implementacoes;

import com.eventoteste.aplicacao.Exceptions.IngressoNaoEncontradoException;
import com.eventoteste.modulos.dtos.response.IngressoResponse;
import com.eventoteste.modulos.entidades.Ingresso;
import com.eventoteste.modulos.mappers.IngressoMapper;
import com.eventoteste.modulos.repositories.IIngressoRepository;
import com.eventoteste.modulos.services.IIngressoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class IngressoServiceImpl implements IIngressoService {
       
    private IIngressoRepository repository;
    private IngressoMapper mapper;

    public IngressoServiceImpl(IIngressoRepository repository, IngressoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Ingresso adicionar(Ingresso Ingresso) {
        return  repository.save(Ingresso);

    }

    @Override
    public Ingresso buscarPorUuid(UUID id) {
        return repository.findById(id).orElseThrow(() -> new IngressoNaoEncontradoException("Ingresso não encontrado"));
    }

    public List<IngressoResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public Ingresso atualizar(UUID uuid, Ingresso Ingresso) {
        Ingresso IngressoAtualizado = buscarPorUuid(uuid);
        mapper.toResponseDTO(Ingresso);
        return repository.saveAndFlush(IngressoAtualizado);
    }

    @Override
    public void excluir(UUID uuid) {
        repository.delete(buscarPorUuid(uuid));
    }
}
