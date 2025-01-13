package com.franquicias.franquicias.infrastruture.rest;

import com.franquicias.franquicias.application.service.SucursalServices;
import com.franquicias.franquicias.domain.Franquicia;
import com.franquicias.franquicias.domain.Sucursal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api_sucursal")
public class ApiSucursalController {
    private final SucursalServices sucursalServices;

    public ApiSucursalController(SucursalServices sucursalServices) {
        this.sucursalServices = sucursalServices;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(sucursalServices.findById(id));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(sucursalServices.findAll());
    }

    @GetMapping(path = "/nombre/{nombre}", produces = "application/json")
    public ResponseEntity<?> getNombre(@PathVariable("nombre") String nombre){
        return ResponseEntity.ok(sucursalServices.findByNombre(nombre));
    }

    @PostMapping( produces = "application/json")
    public ResponseEntity<?> getCreate(@RequestBody Sucursal sucursal){
        System.out.println("nombre 3:"+sucursal.getNombre());
        return ResponseEntity.ok(sucursalServices.create(sucursal));
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getUpdate(@RequestBody Sucursal sucursal, @PathVariable("id") Integer id){
        return ResponseEntity.ok(sucursalServices.updateFranquicia(id, sucursal));
    }

}
