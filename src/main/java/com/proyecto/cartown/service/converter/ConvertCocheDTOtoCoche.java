package com.proyecto.cartown.service.converter;

import com.proyecto.cartown.modelo.Coche;
import com.proyecto.cartown.modelo.dto.CocheDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertCocheDTOtoCoche implements Converter<CocheDTO, Coche> {
    @Override
    public Coche convert(CocheDTO cocheDTO) {
        return Coche.builder()
                .id( cocheDTO.getId() )
                .marca(cocheDTO.getMarca() )
                .modelo(cocheDTO.getModelo())
                .color(cocheDTO.getColor() )
                .potencia(cocheDTO.getPotencia())
                .combustible(cocheDTO.getCombustible())
                .sensores(cocheDTO.getSensores())
                .build();
    }
}
