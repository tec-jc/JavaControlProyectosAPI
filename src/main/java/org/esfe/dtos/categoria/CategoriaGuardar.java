package org.esfe.dtos.categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor // se agregó para el proceso de pruebas
@NoArgsConstructor // se agregó para el proceso de pruebas
@Getter
@Setter
public class CategoriaGuardar implements Serializable {
    private String nombre;
}
