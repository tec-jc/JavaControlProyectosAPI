package org.esfe.servicios.interfaces;

import org.esfe.dtos.tarea.TareaCambiarEstado;
import org.esfe.dtos.tarea.TareaGuardar;
import org.esfe.dtos.tarea.TareaModificar;
import org.esfe.dtos.tarea.TareaSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITareaService {
    List<TareaSalida> obtenerTodos();
    Page<TareaSalida> obtenerTodosPaginados(Pageable pageable);
    TareaSalida obtenerPorId(Integer id);
    List<TareaSalida> obtenerPorProyectoId(Integer id);
    TareaSalida crear(TareaGuardar tareaGuardar);
    TareaSalida editar(TareaModificar tareaModificar);
    TareaSalida cambiarEstado(TareaCambiarEstado tareaCambiarEstado);
    void eliminarPorId(Integer id);
}
