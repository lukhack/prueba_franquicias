package com.franquicias.franquicias.infrastruture.adapter.Impl;

import com.franquicias.franquicias.application.repository.SucursalRepository;
import com.franquicias.franquicias.domain.Producto;
import com.franquicias.franquicias.domain.Sucursal;
import com.franquicias.franquicias.infrastruture.adapter.crud.ProductoCrudRepository;
import com.franquicias.franquicias.infrastruture.adapter.crud.SucursalCrudRepository;
import com.franquicias.franquicias.infrastruture.entity.ProductoEntity;
import com.franquicias.franquicias.infrastruture.entity.SucursalEntity;
import com.franquicias.franquicias.infrastruture.util.MessageSourceHelper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SucursalRepositoryImpl implements SucursalRepository {
    private final SucursalCrudRepository sucursalCrudRepository;
    private final MessageSourceHelper messageSourceHelper;
    private final ModelMapper modelMapper;


    public SucursalRepositoryImpl(SucursalCrudRepository sucursalCrudRepository, MessageSourceHelper messageSourceHelper, ModelMapper modelMapper) {
        this.sucursalCrudRepository = sucursalCrudRepository;
        this.messageSourceHelper = messageSourceHelper;
        this.modelMapper = modelMapper;
    }

    @Override
    public Sucursal findByNombre(String nombre) {
        return this.sucursalCrudRepository.findByNombre(nombre)  .map(sucursalEntity -> this.modelMapper.map(sucursalEntity, Sucursal.class))
                .orElseThrow(() -> new IllegalStateException(messageSourceHelper.getMessage("error.response.not.found")));
    }


    @Override
    public Sucursal findById(Integer id) {
        return this.sucursalCrudRepository.findById(id)
         .map(sucursalEntity -> this.modelMapper.map(sucursalEntity, Sucursal.class))
        .orElseThrow(() -> new IllegalStateException(messageSourceHelper.getMessage("error.response.not.found")));

    }


    @Override
    public Sucursal createSucursal(Sucursal  sucursal) {
        SucursalEntity productoEntity = this.modelMapper.map(sucursal, SucursalEntity.class);
        return this.modelMapper.map(this.sucursalCrudRepository.save(productoEntity), Sucursal.class);
    }


    @Override
    public Sucursal updateSucursal(Integer id, Sucursal  sucursal) {
        return this.sucursalCrudRepository.findById(id)
           .map(existingFranquicia -> {
                existingFranquicia.setNombre(sucursal.getNombre());
                return this.sucursalCrudRepository.save(existingFranquicia);
           })
            .map(( productoEntity)-> this.modelMapper.map(productoEntity, Sucursal.class))
           .orElseThrow(() -> new IllegalStateException(messageSourceHelper.getMessage("error.response.not.found")));

    }

    @Override
    public List<Sucursal> findAll() {
       return StreamSupport.stream(sucursalCrudRepository.findAll().spliterator(), false)
                .map(entity -> modelMapper.map(entity, Sucursal.class))
                .collect(Collectors.toList());
    }



}
