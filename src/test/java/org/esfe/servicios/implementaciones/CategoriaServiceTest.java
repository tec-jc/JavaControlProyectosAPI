package org.esfe.servicios.implementaciones;

import org.esfe.dtos.categoria.CategoriaGuardar;
import org.esfe.dtos.categoria.CategoriaModificar;
import org.esfe.dtos.categoria.CategoriaSalida;
import org.esfe.servicios.interfaces.ICategoriaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoriaServiceTest {

    @Autowired
    private ICategoriaService categoriaService;

    @Test
    void t1_crear() {
        CategoriaSalida salida = categoriaService.crear(new CategoriaGuardar("Categoría de prueba"));
        assertNotEquals(null, salida);
    }

    @Test
    void t2_obtenerTodos() {
        int actual = categoriaService.obtenerTodos().size();
        assertNotEquals(0, actual);
    }

    @Test
    void t3_obtenerTodosPaginados() {
        int actual = categoriaService.obtenerTodosPaginados(
                PageRequest.of(0, 10)).getSize();
        assertNotEquals(0, actual);
    }

    @Test
    void t4_obtenerPorId() {
        CategoriaSalida salida = categoriaService.obtenerPorId(1); // tener cuidado de colocar un id que exista en la tabla
        assertNotEquals(null, salida);
    }

    @Test
    void t5_editar() {
        CategoriaSalida salida = categoriaService.editar(
                new CategoriaModificar(1, "Categoría modificada")
        );
        assertNotEquals(null, salida);
    }

    @Test
    void t6_eliminarPorId() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                categoriaService.eliminarPorId(12); // tener cuidado de colocar un id que exista en la tabla
            }
        });
    }
}