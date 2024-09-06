package org.esfe.repositorios;

import org.esfe.modelos.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITareaRepository extends JpaRepository<Tarea, Integer> {
    List<Tarea> findByProyectoId(Integer id);
}
