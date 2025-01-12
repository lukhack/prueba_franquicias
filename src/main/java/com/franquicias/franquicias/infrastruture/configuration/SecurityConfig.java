package com.franquicias.franquicias.infrastruture.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    public SecurityConfig() {

    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests( // Reemplaza authorizeHttpRequests() con authorizeExchange()
                        matchers -> matchers
                                .anyRequest().permitAll()); // Opcional: permite el acceso a cualquier otra ruta


        return httpSecurity.build();
    }

}
