package com.proyecto.cartown.modelo;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection="Coche")
public class Coche implements Serializable {

    @Id
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
