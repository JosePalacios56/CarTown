package com.proyecto.cartown.modelo;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection="Concesionario")
public class Concesionario implements Serializable {


    @Id
    private String id;
    private String nombre;
    private String direccion;
    private String numero;
    private List<Coche> coches;

}
