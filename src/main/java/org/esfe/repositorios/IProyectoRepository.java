package org.esfe.repositorios;

import org.esfe.modelos.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProyectoRepository extends JpaRepository<Proyecto, Integer> {
}
