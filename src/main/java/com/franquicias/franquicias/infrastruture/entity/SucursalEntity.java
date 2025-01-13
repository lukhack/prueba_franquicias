package com.franquicias.franquicias.infrastruture.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sucursal")
@Data
@NoArgsConstructor
public class SucursalEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;


    @ManyToOne
    @JoinColumn(name = "franquicia_id", referencedColumnName = "id")
    private FranquiciaEntity franquicia;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoEntity> productos;

}
