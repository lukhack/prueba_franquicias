package com.franquicias.franquicias.application.repository;

import com.franquicias.franquicias.domain.Franquicia;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FranquiciaRepository {
    Franquicia createFranquicia(Franquicia franquicia);
    Franquicia updateFranquicia(Integer id, Franquicia franquicia);
    Franquicia findByNombre(String code);
    Franquicia findById(Integer id);
    List<Franquicia> findAll();
}
