package org.esfe.servicios.interfaces;

import org.esfe.dtos.proyecto.ProyectoGuardar;
import org.esfe.dtos.proyecto.ProyectoModificar;
import org.esfe.dtos.proyecto.ProyectoSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProyectoService {
    List<ProyectoSalida> obtenerTodos();

    Page<ProyectoSalida> obtenerTodosPaginados(Pageable pageable);

    ProyectoSalida obtenerPorId(Integer id);

    ProyectoSalida crear(ProyectoGuardar proyectoGuardar);

    ProyectoSalida editar(ProyectoModificar proyectoModificar);

    void eliminarPorId(Integer id);
}
