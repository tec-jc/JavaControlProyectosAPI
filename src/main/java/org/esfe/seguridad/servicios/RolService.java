package org.esfe.seguridad.servicios;

import org.esfe.seguridad.modelos.Rol;
import org.esfe.seguridad.repositorios.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerRoles(){
        return rolRepository.findAll();
    }

    public Rol obtenerPorId(Integer id){
        return rolRepository.findById(id).get();
    }
}
