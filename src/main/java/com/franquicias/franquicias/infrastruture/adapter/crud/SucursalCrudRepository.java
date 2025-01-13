package com.franquicias.franquicias.infrastruture.adapter.crud;


import com.franquicias.franquicias.infrastruture.entity.FranquiciaEntity;
import com.franquicias.franquicias.infrastruture.entity.SucursalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SucursalCrudRepository extends CrudRepository<SucursalEntity, Integer> {
    Optional<SucursalEntity> findByNombre(String nombre);
}
