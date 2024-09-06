package org.esfe.seguridad.repositorios;

import org.esfe.seguridad.modelos.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
