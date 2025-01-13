package com.franquicias.franquicias.infrastruture.adapter.crud;


import com.franquicias.franquicias.infrastruture.entity.ProductoEntity;
import com.franquicias.franquicias.infrastruture.entity.SucursalEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoCrudRepository extends CrudRepository<ProductoEntity, Integer> {
    Optional<ProductoEntity> findByNombre(String nombre);

    @Query("SELECT p FROM ProductoEntity p WHERE p.sucursal.franquicia.id = :franquiciaId AND p.stock = (SELECT MAX(p2.stock) FROM ProductoEntity p2 WHERE p2.sucursal.franquicia.id = :franquiciaId)")
    List<ProductoEntity> findProductoConMasStockPorFranquicia(@Param("franquiciaId") Long franquiciaId);

}
