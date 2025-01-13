package com.franquicias.franquicias.infrastruture.configuration;

import com.franquicias.franquicias.application.repository.FranquiciaRepository;
import com.franquicias.franquicias.application.repository.ProductoRepository;
import com.franquicias.franquicias.application.repository.SucursalRepository;
import com.franquicias.franquicias.application.service.FranquiciaServices;
import com.franquicias.franquicias.application.service.ProductoServices;
import com.franquicias.franquicias.application.service.SucursalServices;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public FranquiciaServices franquiciaServices(FranquiciaRepository franquiciaRepository){
        return new FranquiciaServices(franquiciaRepository);
    }

    @Bean
    public SucursalServices sucursalServices(SucursalRepository sucursalRepository){
        return new SucursalServices(sucursalRepository);
    }

    @Bean
    public ProductoServices productoServices(ProductoRepository productoRepository){
        return new ProductoServices(productoRepository);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
