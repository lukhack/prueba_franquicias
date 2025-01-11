package com.franquicias.franquicias.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Franquicia implements Serializable {
    private Long id;
    private String nombre;
    private List<Sucursal> sucursales;

}
