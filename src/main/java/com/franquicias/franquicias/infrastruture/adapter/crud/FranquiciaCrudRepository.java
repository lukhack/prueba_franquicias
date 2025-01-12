package com.franquicias.franquicias.infrastruture.adapter.crud;


import com.franquicias.franquicias.infrastruture.entity.FranquiciaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FranquiciaCrudRepository extends CrudRepository<FranquiciaEntity, Integer> {
    Optional<FranquiciaEntity> findByNombre(String nombre);
}
