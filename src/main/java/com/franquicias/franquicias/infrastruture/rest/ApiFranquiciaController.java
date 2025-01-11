package com.franquicias.franquicias.infrastruture.rest;

import com.franquicias.franquicias.application.service.FranquiciaServices;
import com.franquicias.franquicias.domain.Franquicia;
import com.icodeap.ecommerce.application.service.EcoBottleServices;
import com.icodeap.ecommerce.domain.EcoBottle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api_franquicia")
public class ApiFranquiciaController {
    private final FranquiciaServices franquiciaServices;

    public ApiFranquiciaController(FranquiciaServices franquiciaServices) {
        this.franquiciaServices = franquiciaServices;
    }

    @GetMapping(path = "/id/{id}", produces = "application/json")
    public ResponseEntity<?> getId(@RequestParam("id") Integer id){
        return ResponseEntity.ok(franquiciaServices.findById(id));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(franquiciaServices.findAll());
    }

    @GetMapping(path = "/{nombre}", produces = "application/json")
    public ResponseEntity<?> getNombre(@RequestParam("nombre") String nombre){
        return ResponseEntity.ok(franquiciaServices.findByNombre(nombre));
    }

    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<?> getCreate(Franquicia franquicia){
        return ResponseEntity.ok(franquiciaServices.create(franquicia));
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<?> getUpdate(Franquicia franquicia, @RequestParam("id") String id){
        return ResponseEntity.ok(franquiciaServices.updateFranquicia(id, franquicia));
    }

}
