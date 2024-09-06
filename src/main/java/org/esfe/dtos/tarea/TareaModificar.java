package org.esfe.dtos.tarea;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TareaModificar implements Serializable {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String duracion;
    private String estado;
    private Integer proyectoId;
}
