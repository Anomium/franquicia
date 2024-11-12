package com.microservicio.api.producto.aplicacion.comando.manejador;

import com.microservicio.api.comun.comun_aplicacion.ComandoRespuesta;
import com.microservicio.api.comun.comun_aplicacion.manejador.ManejadorComandoRespuesta;
import com.microservicio.api.producto.aplicacion.comando.ComandoProducto;
import com.microservicio.api.producto.aplicacion.comando.fabrica.FabricaProducto;
import com.microservicio.api.producto.aplicacion.comando.fabrica.FabricaProductoSucursal;
import com.microservicio.api.producto.dominio.modelo.entidad.Producto;
import com.microservicio.api.producto.dominio.modelo.entidad.ProductoSucursal;
import com.microservicio.api.producto.dominio.servicio.ServicioCrearProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearProducto implements ManejadorComandoRespuesta<ComandoProducto, ComandoRespuesta<Long>> {

    private final FabricaProducto fabricaProducto;
    private final FabricaProductoSucursal fabricaProductoSucursal;
    private final ServicioCrearProducto servicioCrearProducto;

    public ManejadorCrearProducto(FabricaProducto fabricaProducto,
                                  FabricaProductoSucursal fabricaProductoSucursal,
                                  ServicioCrearProducto servicioCrearProducto) {
        this.fabricaProducto = fabricaProducto;
        this.fabricaProductoSucursal = fabricaProductoSucursal;
        this.servicioCrearProducto = servicioCrearProducto;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoProducto comando) {
        Producto producto = this.fabricaProducto.crear(comando);
        Long id = this.servicioCrearProducto.ejecutar(producto);
        ProductoSucursal productoSucursal = this.fabricaProductoSucursal.crear(comando, id);
        return new ComandoRespuesta<>(this.servicioCrearProducto.ejecutar(productoSucursal));
    }
}
