package com.franquicias.franquicias.application.repository;

import com.franquicias.franquicias.domain.Franquicia;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaRepository {
    Franquicia createFranquicia(Franquicia franquicia);
    Franquicia updateFranquicia(String id, Franquicia franquicia);
    Franquicia findByNombre(String code);
    Franquicia findById(Integer id);
    Iterable<Franquicia> findAll();
}
