package com.franquicias.franquicias.infrastruture.rest;

import com.franquicias.franquicias.application.service.FranquiciaServices;
import com.franquicias.franquicias.domain.Franquicia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api_franquicia")
public class ApiFranquiciaController {
    private final FranquiciaServices franquiciaServices;

    public ApiFranquiciaController(FranquiciaServices franquiciaServices) {
        this.franquiciaServices = franquiciaServices;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(franquiciaServices.findById(id));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(franquiciaServices.findAll());
    }

    @GetMapping(path = "/nombre/{nombre}", produces = "application/json")
    public ResponseEntity<?> getNombre(@PathVariable("nombre") String nombre){
        return ResponseEntity.ok(franquiciaServices.findByNombre(nombre));
    }

    @PostMapping( produces = "application/json")
    public ResponseEntity<?> getCreate(@RequestBody Franquicia franquicia){
        System.out.println("nombre 3:"+franquicia.getNombre());
        return ResponseEntity.ok(franquiciaServices.create(franquicia));
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getUpdate(@RequestBody Franquicia franquicia, @PathVariable("id") Integer id){
        return ResponseEntity.ok(franquiciaServices.updateFranquicia(id, franquicia));
    }

}
