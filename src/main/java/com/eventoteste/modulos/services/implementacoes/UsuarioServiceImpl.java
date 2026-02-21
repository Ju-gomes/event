package com.eventoteste.modulos.services.implementacoes;

import com.eventoteste.aplicacao.Exceptions.UsuarioNaoEncontradoException;
import com.eventoteste.aplicacao.configuracao.mapper.GenericMapper;
import com.eventoteste.modulos.entidades.Usuario;
import com.eventoteste.modulos.repositories.IUsuarioRepository;
import com.eventoteste.modulos.services.IUsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private IUsuarioRepository repository;
//    private UsuarioMapper mapper;
    private GenericMapper genericMapper;

    public UsuarioServiceImpl(IUsuarioRepository repository, /*UsuarioMapper mapper,*/ GenericMapper genericMapper) {
        this.repository = repository;
//        this.mapper = mapper;
        this.genericMapper = genericMapper;
    }

    @Override
    public Usuario adicionar(Usuario usuario) {
        return  repository.save(usuario);

    }

    @Override
    public Usuario buscarPorUuid(UUID id) {
        return repository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario não encontrado"));
    }
//
//    public List<UsuarioResponse> listar() {
//        return repository.findAll();
//    }

    @Transactional
    @Override
    public Usuario atualizar(UUID uuid, Usuario usuario) {
        Usuario usuarioAtualizado = buscarPorUuid(uuid);
        genericMapper.map(usuario, usuarioAtualizado);
        return repository.saveAndFlush(usuarioAtualizado);
    }

    @Override
    public void excluir(UUID uuid) {
        repository.delete(buscarPorUuid(uuid));
    }
}
