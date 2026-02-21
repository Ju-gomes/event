package com.eventoteste.aplicacao.configuracao.mapper;

import java.util.Collection;
import java.util.List;

import org.modelmapper.ConfigurationException;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mapeador genérico que utiliza o ModelMapper.
 */
@Component
public class GenericMapper {

    @Autowired
    private ModelMapper mapper;

    /**
     * Retorna as configuraçẽs do ModelMapper.
     * @return {@link Configuration} configurações do ModelMapper.
     */
    public Configuration getConfiguration() {
        return mapper.getConfiguration();
    }

    /**
     * Copia os dados do objeto origem para o objeto destino.
     * @param origem Objeto origem.
     * @param destino Objeto destino.
     * @throws IllegalArgumentException - Se origem ou destino forem null.
     * @throws ConfigurationException - Se o ModelMapper não conseguir localizar ou criar um TypeMap para os argumentos.
     * @throws MappingException - Se ocorrer algum erro durante o mapeamento.
     */
    public <O, D> void map(O origem, D destino) {
        mapper.map(origem, destino);
    }

    /**
     * Copia os dados do objeto origem para uma nova instância da classe destino.
     * @param origem Objeto Origem.
     * @param clazz Classe destino.
     * @return Uma nova instância da classe destino com os dados mapeados do objeto origem.
     * @throws IllegalArgumentException - Se origem ou clazz forem null.
     * @throws ConfigurationException - Se o ModelMapper não conseguir localizar ou criar um TypeMap para os argumentos.
     * @throws MappingException - Se ocorrer algum erro durante o mapeamento.
     */
    public <O, D> D map(O origem, Class<D> clazz) {
        return mapper.map(origem, clazz);
    }

    /**
     * Copia uma lista de objetos origem para uma nova lista de objetos da classe destino.
     * @param origem Coleção de objetos.
     * @param clazz Tipo de classe da coleção retornada.
     * @return Uma nova lista de objetos da classe destino mapeados com os dados da lista origem.
     * @throws IllegalArgumentException - Se origem ou clazz forem null.
     * @throws ConfigurationException - Se o ModelMapper não conseguir localizar ou criar um TypeMap para os argumentos.
     * @throws MappingException - Se ocorrer algum erro durante o mapeamento.
     */
    public <O, D> List<D> map(Collection<O> origem, Class<D> clazz) {
        return origem.stream()
                .map(o -> mapper.map(o, clazz))
                .toList();
    }

}

