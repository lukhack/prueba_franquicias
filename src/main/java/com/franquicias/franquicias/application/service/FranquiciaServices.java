package com.franquicias.franquicias.application.service;

import com.franquicias.franquicias.application.repository.FranquiciaRepository;
import com.franquicias.franquicias.domain.Franquicia;

public class FranquiciaServices {
    private final FranquiciaRepository franquiciaRepository;



    public FranquiciaServices(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
    }

    public Franquicia create(Franquicia ecoBottle) {
        return franquiciaRepository.createFranquicia(ecoBottle);
    }

    public Franquicia findByNombre(String name) {
        return franquiciaRepository.findByNombre(name);
    }

    public Franquicia updateFranquicia(String id, Franquicia franquicia) {
        return franquiciaRepository.updateFranquicia(id, franquicia);
    }



    public Franquicia findById(Integer id){
        return franquiciaRepository.findById(id);
    }


    public Iterable<Franquicia> findAll(){
        return franquiciaRepository.findAll();
    }



}
