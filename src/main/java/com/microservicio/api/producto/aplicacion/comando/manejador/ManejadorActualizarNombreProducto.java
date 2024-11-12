package com.microservicio.api.producto.aplicacion.comando.manejador;

import com.microservicio.api.comun.comun_aplicacion.manejador.ManejadorComando;
import com.microservicio.api.producto.aplicacion.comando.ComandoActualizarProducto;
import com.microservicio.api.producto.aplicacion.comando.fabrica.FabricaActualizarProducto;
import com.microservicio.api.producto.dominio.modelo.entidad.ProductoActualizar;
import com.microservicio.api.producto.dominio.servicio.ServicioActualizarNombreProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarNombreProducto implements ManejadorComando<ComandoActualizarProducto> {

    private final FabricaActualizarProducto fabricaActualizarProducto;
    private final ServicioActualizarNombreProducto servicioActualizarNombreProducto;

    public ManejadorActualizarNombreProducto(FabricaActualizarProducto fabricaActualizarProducto,
                                             ServicioActualizarNombreProducto servicioActualizarNombreProducto) {
        this.fabricaActualizarProducto = fabricaActualizarProducto;
        this.servicioActualizarNombreProducto = servicioActualizarNombreProducto;
    }

    @Override
    public void ejecutar(ComandoActualizarProducto comandoActualizarProducto) {
        ProductoActualizar productoActualizar = fabricaActualizarProducto.crear(comandoActualizarProducto);
        this.servicioActualizarNombreProducto.ejecutar(productoActualizar);
    }

}
