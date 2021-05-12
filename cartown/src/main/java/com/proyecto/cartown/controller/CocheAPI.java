package com.proyecto.cartown.controller;


import com.proyecto.cartown.controller.constant.EndPointUris;
import com.proyecto.cartown.modelo.dto.CocheDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping( EndPointUris.COCHES )
public interface CocheAPI {

    @GetMapping
    ResponseEntity<List<CocheDTO>> getAll();

    @PostMapping
    ResponseEntity< CocheDTO > create( @RequestBody final CocheDTO cocheDTO );

    @PutMapping
    ResponseEntity< CocheDTO > update( @RequestBody final CocheDTO cocheDTO );

    @DeleteMapping( EndPointUris.ID )
    ResponseEntity< Boolean > delete( @PathVariable final int id );

    @DeleteMapping
    ResponseEntity<Boolean> deleteAllCoches();

    @GetMapping(EndPointUris.ID)
    ResponseEntity<Optional<CocheDTO>> getCocheById(@PathVariable final String id);

}
