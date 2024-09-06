package org.esfe.dtos.tarea;

import lombok.Getter;
import lombok.Setter;

import org.esfe.dtos.proyecto.ProyectoSalida;
import java.io.Serializable;

@Setter
@Getter
public class TareaSalida implements Serializable {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String duracion;
    private String estado;
    private ProyectoSalida proyecto;
}
