package com.microservicio.api.producto.aplicacion.comando.manejador;

import com.microservicio.api.comun.comun_aplicacion.manejador.ManejadorComando;
import com.microservicio.api.producto.aplicacion.comando.ComandoActualizarProducto;
import com.microservicio.api.producto.aplicacion.comando.fabrica.FabricaActualizarProducto;
import com.microservicio.api.producto.dominio.modelo.entidad.ProductoActualizar;
import com.microservicio.api.producto.dominio.servicio.ServicioActualizarStockProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarStockProducto  implements ManejadorComando<ComandoActualizarProducto> {

    private final FabricaActualizarProducto fabricaActualizarProducto;
    private final ServicioActualizarStockProducto servicioActualizarStockProducto;

    public ManejadorActualizarStockProducto(FabricaActualizarProducto fabricaActualizarProducto,
                                            ServicioActualizarStockProducto servicioActualizarStockProducto) {
        this.fabricaActualizarProducto = fabricaActualizarProducto;
        this.servicioActualizarStockProducto = servicioActualizarStockProducto;
    }

    @Override
    public void ejecutar(ComandoActualizarProducto comandoActualizarProducto) {
        ProductoActualizar productoActualizar = fabricaActualizarProducto.crear(comandoActualizarProducto);
        this.servicioActualizarStockProducto.ejecutar(productoActualizar);
    }
}
