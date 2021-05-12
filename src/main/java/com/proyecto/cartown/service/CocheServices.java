package com.proyecto.cartown.service;

import com.proyecto.cartown.modelo.dto.CocheDTO;

import java.util.List;

public interface CocheServices {


    List<CocheDTO> getAll();

    CocheDTO create (final CocheDTO cochedto);

    CocheDTO update( final CocheDTO tutorial);

    Boolean delete ( final String id);

    Boolean deleteAllCoches();

}
