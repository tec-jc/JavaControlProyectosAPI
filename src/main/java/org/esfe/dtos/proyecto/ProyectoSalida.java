package org.esfe.dtos.proyecto;

import lombok.Getter;
import lombok.Setter;
import org.esfe.dtos.categoria.CategoriaSalida;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ProyectoSalida implements Serializable {
    private Integer id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private CategoriaSalida categoria;
}
