package org.esfe.dtos.proyecto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor // se agregó para proceso de pruebas
@NoArgsConstructor // se agregó para proceso de pruebas
@Getter
@Setter
public class ProyectoModificar implements Serializable {
    private Integer id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer categoriaId;
}
