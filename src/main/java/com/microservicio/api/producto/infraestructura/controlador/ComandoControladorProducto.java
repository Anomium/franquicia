package com.microservicio.api.producto.infraestructura.controlador;

import com.microservicio.api.comun.comun_aplicacion.ComandoRespuesta;
import com.microservicio.api.producto.aplicacion.comando.ComandoActualizarProducto;
import com.microservicio.api.producto.aplicacion.comando.ComandoProducto;
import com.microservicio.api.producto.aplicacion.comando.manejador.ManejadorActualizarNombreProducto;
import com.microservicio.api.producto.aplicacion.comando.manejador.ManejadorCrearProducto;
import com.microservicio.api.producto.aplicacion.comando.manejador.ManejadorEliminarProducto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
@Api(tags = {"Controlador comando producto"})
public class ComandoControladorProducto {

    private final ManejadorCrearProducto manejadorCrearProducto;
    private final ManejadorActualizarNombreProducto manejadorActualizarNombreProducto;
    private final ManejadorEliminarProducto manejadorEliminarProducto;

    public ComandoControladorProducto(ManejadorCrearProducto manejadorCrearProducto,
                                      ManejadorActualizarNombreProducto manejadorActualizarNombreProducto,
                                      ManejadorEliminarProducto manejadorEliminarProducto) {
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manejadorActualizarNombreProducto = manejadorActualizarNombreProducto;
        this.manejadorEliminarProducto = manejadorEliminarProducto;
    }

    @Operation(summary = "Crea un producto")
    @PostMapping
    public ComandoRespuesta<Long> create(@RequestBody ComandoProducto comandoProducto) {
        return manejadorCrearProducto.ejecutar(comandoProducto);
    }

    @PutMapping
    public void update(@RequestBody ComandoActualizarProducto comandoActualizarProducto) {
        manejadorActualizarNombreProducto.ejecutar(comandoActualizarProducto);
    }

    @Operation(summary = "Elimina un producto por id")
    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarProducto.ejecutar(id);
    }

}
