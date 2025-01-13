package com.franquicias.franquicias.infrastruture.rest;

import com.franquicias.franquicias.application.service.ProductoServices;
import com.franquicias.franquicias.application.service.SucursalServices;
import com.franquicias.franquicias.domain.Producto;
import com.franquicias.franquicias.domain.Sucursal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api_producto")
public class ApiProductoController {
    private final ProductoServices productoServices;

    public ApiProductoController(ProductoServices productoServices) {
        this.productoServices = productoServices;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(productoServices.findById(id));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(productoServices.findAll());
    }

    //extrea el producto de mayor valor
    @GetMapping(path = "/max/{id}", produces = "application/json")
    public ResponseEntity<?> getMax(@PathVariable("id") Long franquiciaId){
        return ResponseEntity.ok(productoServices.findAllMax(franquiciaId));
    }

    @PostMapping( produces = "application/json")
    public ResponseEntity<?> getCreate(@RequestBody Producto producto){
        System.out.println("nombre 3:"+producto.getNombre());
        return ResponseEntity.ok(productoServices.create(producto));
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getUpdate(@RequestBody Producto producto, @PathVariable("id") Integer id){
        return ResponseEntity.ok(productoServices.updateProducto(id, producto));
    }


    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getDelete( @PathVariable("id") Integer id){
        productoServices.delete(id);
        return ResponseEntity.ok("Datos eliminados correctamente");
    }

}
