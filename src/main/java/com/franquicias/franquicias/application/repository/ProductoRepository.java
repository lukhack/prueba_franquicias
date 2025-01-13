package com.franquicias.franquicias.application.repository;

import com.franquicias.franquicias.domain.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository {
    Producto createProducto(Producto producto);
    Producto updateProducto(Integer id, Producto producto);
    Producto findByNombre(String code);
    Producto findById(Integer id);
    void delete(Integer id);
    List<Producto> findAll();
    List<Producto> findAllMax(Long franquiciaId);
}
