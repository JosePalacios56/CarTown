package com.proyecto.cartown.service.converter;

import com.proyecto.cartown.modelo.Coche;
import com.proyecto.cartown.modelo.dto.CocheDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertCocheToCocheDTO implements Converter<Coche, CocheDTO > {
    @Override
    public CocheDTO convert(Coche coche) {
        return CocheDTO.builder()
                .id( coche.getId() )
                .marca(coche.getMarca() )
                .modelo(coche.getModelo())
                .color(coche.getColor() )
                .potencia(coche.getPotencia())
                .combustible(coche.getCombustible())
                .imagenes(coche.getImagenes())
                .plazas(coche.getPlazas())
                .marchas(coche.getMarchas())
                .build();
    }
}
