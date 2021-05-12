package com.proyecto.cartown.modelo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CocheDTO {

    private int id;
    private String marca;
    private String modelo;
    private String color;
    private int potencia;
    private String combustible;
    private Boolean sensores;
}
