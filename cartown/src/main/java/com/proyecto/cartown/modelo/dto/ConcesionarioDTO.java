package com.proyecto.cartown.modelo.dto;

import com.proyecto.cartown.modelo.Coche;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConcesionarioDTO {

    private String id;
    private String nombre;
    private String direccion;
    private String numero;
    private List<Coche>Coches;

}
