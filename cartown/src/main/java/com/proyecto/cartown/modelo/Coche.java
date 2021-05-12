package com.proyecto.cartown.modelo;


import com.sun.istack.internal.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection="Coche")
public class Coche implements Serializable {

    @Id
    @NotNull
    private int id;

    private String marca;

    private String modelo;

    private String color;

    private int potencia;

    private String combustible;

    private Boolean sensores;

}
