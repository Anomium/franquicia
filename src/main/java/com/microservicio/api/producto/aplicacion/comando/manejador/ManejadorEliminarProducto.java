package com.microservicio.api.producto.aplicacion.comando.manejador;

import com.microservicio.api.comun.comun_aplicacion.manejador.ManejadorComando;
import com.microservicio.api.producto.dominio.servicio.ServicioEliminarProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarProducto implements ManejadorComando<Long> {

    private final ServicioEliminarProducto servicioEliminarProducto;

    public ManejadorEliminarProducto(ServicioEliminarProducto servicioEliminarProducto) {
        this.servicioEliminarProducto = servicioEliminarProducto;
    }

    @Override
    public void ejecutar(Long idProducto) {
        this.servicioEliminarProducto.ejecutar(idProducto);
    }
}
