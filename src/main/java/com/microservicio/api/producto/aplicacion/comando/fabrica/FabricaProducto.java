package com.microservicio.api.producto.aplicacion.comando.fabrica;

import com.microservicio.api.producto.aplicacion.comando.ComandoProducto;
import com.microservicio.api.producto.dominio.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {

    public Producto crear(ComandoProducto comandoProducto) {
        return new Producto(comandoProducto.getNombre(),
                comandoProducto.getDescripcion(),
                comandoProducto.getPrecioBase()
        );
    }

}
