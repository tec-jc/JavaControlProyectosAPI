package org.esfe.servicios.implementaciones;

import org.esfe.dtos.proyecto.ProyectoGuardar;
import org.esfe.dtos.proyecto.ProyectoModificar;
import org.esfe.dtos.proyecto.ProyectoSalida;
import org.esfe.modelos.Proyecto;
import org.esfe.repositorios.IProyectoRepository;
import org.esfe.servicios.interfaces.IProyectoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProyectoService implements IProyectoService {
    @Autowired
    private IProyectoRepository proyectoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProyectoSalida> obtenerTodos() {
        List<Proyecto> proyectos = proyectoRepository.findAll();

        return proyectos.stream()
                .map(proyecto -> modelMapper.map(proyecto, ProyectoSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProyectoSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<Proyecto> page = proyectoRepository.findAll(pageable);

        List<ProyectoSalida> proyectosDto = page.stream()
                .map(proyecto -> modelMapper.map(proyecto, ProyectoSalida.class))
                .collect(Collectors.toList());
        return new PageImpl<>(proyectosDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public ProyectoSalida obtenerPorId(Integer id) {
        Optional<Proyecto> proyecto = proyectoRepository.findById(id);

        if(proyecto.isPresent()){
            return modelMapper.map(proyecto.get(), ProyectoSalida.class);
        }
        return null;
    }

    @Override
    public ProyectoSalida crear(ProyectoGuardar proyectoGuardar) {
        Proyecto proyecto = modelMapper.map(proyectoGuardar, Proyecto.class);
        proyecto.setId(null);

        return modelMapper.map(proyectoRepository.save(proyecto), ProyectoSalida.class);
    }

    @Override
    public ProyectoSalida editar(ProyectoModificar proyectoModificar) {
        Proyecto proyecto = proyectoRepository.save(modelMapper.map(proyectoModificar, Proyecto.class));

        return modelMapper.map(proyecto, ProyectoSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        proyectoRepository.deleteById(id);
    }
}
