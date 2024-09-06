package org.esfe.controladores;

import org.esfe.dtos.proyecto.ProyectoGuardar;
import org.esfe.dtos.proyecto.ProyectoModificar;
import org.esfe.dtos.proyecto.ProyectoSalida;
import org.esfe.servicios.interfaces.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {
    @Autowired
    private IProyectoService proyectoService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<Page<ProyectoSalida>> mostrarTodosPaginados(Pageable pageable){
        Page<ProyectoSalida> proyectos = proyectoService.obtenerTodosPaginados(pageable);

        if(proyectos.hasContent()){
            return ResponseEntity.ok(proyectos);
        }
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/lista")
    public ResponseEntity<List<ProyectoSalida>> mostrarTodos(){
        List<ProyectoSalida> proyectos = proyectoService.obtenerTodos();

        if(!proyectos.isEmpty()){
            return ResponseEntity.ok(proyectos);
        }
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<ProyectoSalida> mostrarPorId(@PathVariable Integer id){
        ProyectoSalida proyecto = proyectoService.obtenerPorId(id);

        if(proyecto != null){
            return ResponseEntity.ok(proyecto);
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ProyectoSalida> crear(@RequestBody ProyectoGuardar proyectoGuardar){
        ProyectoSalida proyecto = proyectoService.crear(proyectoGuardar);

        if(proyecto != null){
            return ResponseEntity.ok(proyecto);
        }

        return ResponseEntity.internalServerError().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ProyectoSalida> editar(@PathVariable Integer id, @RequestBody ProyectoModificar proyectoModificar){
        ProyectoSalida proyecto = proyectoService.editar(proyectoModificar);

        if(proyecto != null){
            return ResponseEntity.ok(proyecto);
        }

        return ResponseEntity.internalServerError().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        proyectoService.eliminarPorId(id);
        return ResponseEntity.ok("Proyecto eliminado correctamente");
    }
}
