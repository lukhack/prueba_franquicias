package com.franquicias.franquicias.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private Long id;
    private String nombre;
    private int stock;
    private Sucursal sucursal;
}
