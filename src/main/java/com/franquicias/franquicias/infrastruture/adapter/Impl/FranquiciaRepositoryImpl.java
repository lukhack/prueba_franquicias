package com.franquicias.franquicias.infrastruture.adapter.Impl;

import com.franquicias.franquicias.application.repository.FranquiciaRepository;
import com.franquicias.franquicias.domain.Franquicia;
import com.franquicias.franquicias.infrastruture.adapter.crud.FranquiciaCrudRepository;
import com.franquicias.franquicias.infrastruture.entity.FranquiciaEntity;
import com.franquicias.franquicias.infrastruture.util.MessageSourceHelper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class FranquiciaRepositoryImpl implements FranquiciaRepository {
    private final FranquiciaCrudRepository franquiciaCrudRepository;
    private final MessageSourceHelper messageSourceHelper;
    private final ModelMapper modelMapper;


    public FranquiciaRepositoryImpl(FranquiciaCrudRepository franquiciaCrudRepository, MessageSourceHelper messageSourceHelper, ModelMapper modelMapper) {
        this.franquiciaCrudRepository = franquiciaCrudRepository;
        this.messageSourceHelper = messageSourceHelper;
        this.modelMapper = modelMapper;
    }

    @Override
    public Franquicia findByNombre(String nombre) {
        return this.franquiciaCrudRepository.findByNombre(nombre)  .map(franquiciaEntity -> this.modelMapper.map(franquiciaEntity, Franquicia.class))
                .orElseThrow(() -> new IllegalStateException(messageSourceHelper.getMessage("error.response.not.found")));
    }


    @Override
    public Franquicia findById(Integer id) {
        return this.franquiciaCrudRepository.findById(id)
         .map(franquiciaEntity -> this.modelMapper.map(franquiciaEntity, Franquicia.class))
        .orElseThrow(() -> new IllegalStateException(messageSourceHelper.getMessage("error.response.not.found")));

    }


    @Override
    public Franquicia createFranquicia(Franquicia  franquicia) {
        FranquiciaEntity franquiciaEntity = this.modelMapper.map(franquicia, FranquiciaEntity.class);
        return this.modelMapper.map(this.franquiciaCrudRepository.save(franquiciaEntity), Franquicia.class);
    }


    @Override
    public Franquicia updateFranquicia(Integer id, Franquicia  franquicia) {
        return this.franquiciaCrudRepository.findById(id)
           .map(existingFranquicia -> {
                existingFranquicia.setNombre(franquicia.getNombre());
                return this.franquiciaCrudRepository.save(existingFranquicia);
           })
            .map(( franquiciaEntity)-> this.modelMapper.map(franquiciaEntity, Franquicia.class))
           .orElseThrow(() -> new IllegalStateException(messageSourceHelper.getMessage("error.response.not.found")));

    }

    @Override
    public List<Franquicia> findAll() {
       return StreamSupport.stream(franquiciaCrudRepository.findAll().spliterator(), false)
                .map(entity -> modelMapper.map(entity, Franquicia.class))
                .collect(Collectors.toList());
    }



}
