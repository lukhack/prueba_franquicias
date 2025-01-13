package com.franquicias.franquicias.application.service;

import com.franquicias.franquicias.application.repository.SucursalRepository;
import com.franquicias.franquicias.domain.Sucursal;

import java.util.List;

public class SucursalServices {
    private final SucursalRepository sucursalRepository;



    public SucursalServices(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    public Sucursal create(Sucursal sucursal) {
        return sucursalRepository.createSucursal(sucursal);
    }

    public Sucursal findByNombre(String name) {
        return sucursalRepository.findByNombre(name);
    }

    public Sucursal updateFranquicia(Integer id, Sucursal sucursal) {
        return sucursalRepository.updateSucursal(id, sucursal);
    }

    public Sucursal findById(Integer id){
        return sucursalRepository.findById(id);
    }

    public List<Sucursal> findAll(){
        return sucursalRepository.findAll();
    }



}
