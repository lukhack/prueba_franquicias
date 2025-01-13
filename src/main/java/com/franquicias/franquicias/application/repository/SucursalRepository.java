package com.franquicias.franquicias.application.repository;

import com.franquicias.franquicias.domain.Sucursal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SucursalRepository {
    Sucursal createSucursal(Sucursal sucursal);
    Sucursal updateSucursal(Integer id, Sucursal sucursal);
    Sucursal findByNombre(String code);
    Sucursal findById(Integer id);
    List<Sucursal> findAll();
}
