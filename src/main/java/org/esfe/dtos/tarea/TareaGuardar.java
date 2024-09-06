package org.esfe.dtos.tarea;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class TareaGuardar implements Serializable {
    private String nombre;
    private String descripcion;
    private String duracion;
    private Integer proyectoId;
}
