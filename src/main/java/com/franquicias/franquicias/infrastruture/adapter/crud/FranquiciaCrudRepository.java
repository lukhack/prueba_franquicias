package com.franquicias.franquicias.infrastruture.adapter.crud;


import com.icodeap.ecommerce.domain.EcoBottleState;
import com.icodeap.ecommerce.infrastructure.entity.EcoBottleEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface FranquiciaCrudRepository extends CrudRepository<EcoBottleEntity, Integer> {
    Optional<EcoBottleEntity> findByDateCreated(LocalDate date);
    Optional<EcoBottleEntity> findByBottleState(EcoBottleState bottleState);
    Optional<EcoBottleEntity> findByCode(String code);
    Optional<EcoBottleEntity> findByCodeAndKey(String code,String key);
    Optional<EcoBottleEntity> findByKey(String key);


}
