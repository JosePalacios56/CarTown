package com.proyecto.cartown.controller.impl;

import com.proyecto.cartown.controller.CocheAPI;
import com.proyecto.cartown.modelo.dto.CocheDTO;
import com.proyecto.cartown.repository.CocheRepository;
import com.proyecto.cartown.service.CocheServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CocheController implements CocheAPI {

    @Autowired
    private CocheServices cocheServices;

    @Override
    public ResponseEntity<List<CocheDTO>> getAll() {
        return  ResponseEntity.ok( cocheServices.getAll());
    }

    @Override
    public ResponseEntity<CocheDTO> create(CocheDTO cocheDTO) {
        return new ResponseEntity<>(cocheServices.create(cocheDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CocheDTO> update(CocheDTO cocheDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> delete(String id) {
        return cocheServices.delete( id )
                ? ResponseEntity.ok( true )
                : new ResponseEntity <>( false, HttpStatus.NOT_FOUND );
    }

    @Override
    public ResponseEntity<Boolean> deleteAllCoches() {
        return cocheServices.deleteAllCoches()?ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Optional<CocheDTO>> getCocheById(String id) {
        return null;
    }
}
