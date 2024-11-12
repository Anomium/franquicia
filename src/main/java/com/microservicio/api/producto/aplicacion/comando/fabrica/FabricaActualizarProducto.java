package com.microservicio.api.producto.aplicacion.comando.fabrica;

import com.microservicio.api.producto.aplicacion.comando.ComandoActualizarProducto;
import com.microservicio.api.producto.dominio.modelo.entidad.ProductoActualizar;
import org.springframework.stereotype.Component;

@Component
public class FabricaActualizarProducto {

    public ProductoActualizar crear(ComandoActualizarProducto comandoActualizarProducto) {
        return new ProductoActualizar(
                comandoActualizarProducto.getId(),
                comandoActualizarProducto.getNombreNuevo()
        );
    }

}
