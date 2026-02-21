package com.eventoteste.aplicacao.configuracao.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();

		// Desabilitar mapeamento implícito para Records
		mapper.getConfiguration()
				.setFieldMatchingEnabled(true)
				.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
				.setSourceNamingConvention(NamingConventions.JAVABEANS_ACCESSOR)
				.setDestinationNamingConvention(NamingConventions.JAVABEANS_MUTATOR)
				.setMatchingStrategy(MatchingStrategies.STRICT)
				.setSkipNullEnabled(true)
				.setAmbiguityIgnored(true);

		return mapper;
	}

//	@Bean
//	public MapperService mappingService(ModelMapperConfig modelMapper) {
//		return new MapperService(modelMapper);
//	}
}
