package com.franquicias.franquicias.infrastruture.adapter.Impl;

import com.franquicias.franquicias.application.repository.FranquiciaRepository;
import com.franquicias.franquicias.application.repository.ProductoRepository;
import com.franquicias.franquicias.domain.Producto;
import com.franquicias.franquicias.infrastruture.adapter.crud.ProductoCrudRepository;
import com.franquicias.franquicias.infrastruture.entity.FranquiciaEntity;
import com.franquicias.franquicias.infrastruture.entity.ProductoEntity;
import com.franquicias.franquicias.infrastruture.util.MessageSourceHelper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProdcutoRepositoryImpl implements ProductoRepository {
    private final ProductoCrudRepository productoCrudRepository;
    private final MessageSourceHelper messageSourceHelper;
    private final ModelMapper modelMapper;


    public ProdcutoRepositoryImpl(ProductoCrudRepository franquiciaCrudRepository, MessageSourceHelper messageSourceHelper, ModelMapper modelMapper) {
        this.productoCrudRepository = franquiciaCrudRepository;
        this.messageSourceHelper = messageSourceHelper;
        this.modelMapper = modelMapper;
    }

    @Override
    public Producto findByNombre(String nombre) {
        return this.productoCrudRepository.findByNombre(nombre)  .map(franquiciaEntity -> this.modelMapper.map(franquiciaEntity, Producto.class))
                .orElseThrow(() -> new IllegalStateException(messageSourceHelper.getMessage("error.response.not.found")));
    }


    @Override
    public Producto findById(Integer id) {
        return this.productoCrudRepository.findById(id)
         .map(franquiciaEntity -> this.modelMapper.map(franquiciaEntity, Producto.class))
        .orElseThrow(() -> new IllegalStateException(messageSourceHelper.getMessage("error.response.not.found")));
    }

    @Override
    public void delete(Integer id) {
        this.productoCrudRepository.deleteById(id);
    }

    @Override
    public Producto createProducto(Producto  producto) {
        ProductoEntity productoEntity = this.modelMapper.map(producto, ProductoEntity.class);
        return this.modelMapper.map(this.productoCrudRepository.save(productoEntity), Producto.class);
    }


    @Override
    public Producto updateProducto(Integer id, Producto  franquicia) {
        return this.productoCrudRepository.findById(id)
           .map(existingFranquicia -> {
                existingFranquicia.setNombre(franquicia.getNombre()==null?existingFranquicia.getNombre():franquicia.getNombre());
               existingFranquicia.setStock(franquicia.getStock()==null?existingFranquicia.getStock():franquicia.getStock());

               return this.productoCrudRepository.save(existingFranquicia);
           })
            .map(( franquiciaEntity)-> this.modelMapper.map(franquiciaEntity, Producto.class))
           .orElseThrow(() -> new IllegalStateException(messageSourceHelper.getMessage("error.response.not.found")));

    }

    @Override
    public List<Producto> findAll() {
       return StreamSupport.stream(productoCrudRepository.findAll().spliterator(), false)
                .map(entity -> modelMapper.map(entity, Producto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Producto> findAllMax(Long franquiciaId) {
        return StreamSupport.stream(productoCrudRepository.findProductoConMasStockPorFranquicia(franquiciaId).spliterator(), false)
                .map(entity -> modelMapper.map(entity, Producto.class))
                .collect(Collectors.toList());
    }


}
