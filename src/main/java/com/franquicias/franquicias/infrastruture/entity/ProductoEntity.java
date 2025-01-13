package com.franquicias.franquicias.infrastruture.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
public class ProductoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private SucursalEntity sucursal;
}
