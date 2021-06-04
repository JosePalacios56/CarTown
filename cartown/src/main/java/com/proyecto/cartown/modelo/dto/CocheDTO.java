package com.proyecto.cartown.modelo.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CocheDTO {

    private String id;
    private String marca;
    private String modelo;
    private String color;
    private int potencia;
    private String combustible;
    private ArrayList<String> imagenes;
    private int plazas;
    private String marchas;
}
