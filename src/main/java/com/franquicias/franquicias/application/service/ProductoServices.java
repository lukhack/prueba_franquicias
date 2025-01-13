package com.franquicias.franquicias.application.service;

import com.franquicias.franquicias.application.repository.ProductoRepository;
import com.franquicias.franquicias.domain.Producto;

import java.util.List;

public class ProductoServices {
    private final ProductoRepository prosuctoRepository;

    public ProductoServices(ProductoRepository sucursalRepository) {
        this.prosuctoRepository = sucursalRepository;
    }

    public Producto create(Producto producto) {
        return prosuctoRepository.createProducto(producto);
    }

    public Producto findByNombre(String name) {
        return prosuctoRepository.findByNombre(name);
    }

    public Producto updateProducto(Integer id, Producto producto) {
        return prosuctoRepository.updateProducto(id, producto);
    }

    public Producto findById(Integer id){
        return prosuctoRepository.findById(id);
    }

    public List<Producto> findAll(){
        return prosuctoRepository.findAll();
    }

    public List<Producto> findAllMax(Long franquiciaId){
        return prosuctoRepository.findAllMax(franquiciaId);
    }
}
