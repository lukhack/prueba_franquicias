package com.franquicias.franquicias.infrastruture.configuration;

import com.franquicias.franquicias.application.repository.FranquiciaRepository;
import com.franquicias.franquicias.application.service.FranquiciaServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {
    @Bean
    public FranquiciaServices franquiciaServices(FranquiciaRepository franquiciaRepository){
        return new FranquiciaServices(franquiciaRepository);
    }



}
