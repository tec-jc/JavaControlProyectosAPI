package org.esfe.dtos.categoria;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CategoriaModificar implements Serializable {
    private Integer id;
    private String nombre;
}
