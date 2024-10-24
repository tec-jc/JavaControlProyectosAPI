package org.esfe.servicios.implementaciones;

import org.esfe.dtos.proyecto.ProyectoGuardar;
import org.esfe.dtos.proyecto.ProyectoModificar;
import org.esfe.dtos.proyecto.ProyectoSalida;
import org.esfe.servicios.interfaces.IProyectoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProyectoServiceTest {

    @Autowired
    private IProyectoService proyectoService;

    @Test
    void crear() {
        ProyectoSalida salida = proyectoService.crear(
                new ProyectoGuardar("Título de prueba", "Descripción de prueba",
                        LocalDate.of(2024, 10, 24),
                        LocalDate.of(2025, 2, 20), 1)
                // tener cuidado en colocar una referencia válida, el id debe existir en la tabla referenciada
        );
        assertNotEquals(null, salida);
    }

    @Test
    void obtenerTodos() {
        int actual = proyectoService.obtenerTodos().size();
        assertNotEquals(0, actual);
    }

    @Test
    void obtenerTodosPaginados() {
        int actual = proyectoService.obtenerTodosPaginados(
                PageRequest.of(0, 10)
        ).getSize();
        assertNotEquals(0, actual);
    }

    @Test
    void obtenerPorId() {
        ProyectoSalida salida = proyectoService.obtenerPorId(2); // tener cudidado en colocar un id que exista en la tabla
        assertNotEquals(null, salida);
    }

    @Test
    void editar() {
        ProyectoSalida salida = proyectoService.editar(
                new ProyectoModificar(8, "Titulo modificado",
                        "Descripción modificada",
                        LocalDate.of(2024, 10, 24),
                        LocalDate.of(2025, 1, 20), 1)
                // tener cuidado en colocar una referencia válida, el id debe existir en la tabla referenciada
        );
        assertNotEquals(null, salida);
    }

    @Test
    void eliminarPorId() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                proyectoService.eliminarPorId(8); // tener cudidado en colocar un id que exista en la tabla
            }
        });
    }
}