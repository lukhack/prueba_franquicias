package com.franquicias.franquicias.infrastruture.adapter.crud;


import com.franquicias.franquicias.infrastruture.entity.ProductoEntity;
import com.franquicias.franquicias.infrastruture.entity.SucursalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoCrudRepository extends CrudRepository<ProductoEntity, Integer> {
    Optional<ProductoEntity> findByNombre(String nombre);
}
