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
public class Sucursal implements Serializable {
    private Long id;
    private String nombre;
    private List<Producto> productos;
    private Franquicia franquicia;

}
