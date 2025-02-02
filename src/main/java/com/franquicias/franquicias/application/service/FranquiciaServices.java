package com.franquicias.franquicias.application.service;

import com.franquicias.franquicias.application.repository.FranquiciaRepository;
import com.franquicias.franquicias.domain.Franquicia;
import com.franquicias.franquicias.domain.Producto;

import java.util.List;

public class FranquiciaServices {
    private final FranquiciaRepository franquiciaRepository;



    public FranquiciaServices(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
    }

    public Franquicia create(Franquicia franquicia) {
        return franquiciaRepository.createFranquicia(franquicia);
    }

    public Franquicia findByNombre(String name) {
        return franquiciaRepository.findByNombre(name);
    }

    public Franquicia updateFranquicia(Integer id, Franquicia franquicia) {
        return franquiciaRepository.updateFranquicia(id, franquicia);
    }

    public Franquicia findById(Integer id){
        return franquiciaRepository.findById(id);
    }

    public List<Franquicia> findAll(){
        return franquiciaRepository.findAll();
    }




}
