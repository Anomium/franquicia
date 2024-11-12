package com.microservicio.api.producto.aplicacion.comando.fabrica;

import com.microservicio.api.producto.aplicacion.comando.ComandoProducto;
import com.microservicio.api.producto.dominio.modelo.entidad.Producto;
import com.microservicio.api.producto.dominio.modelo.entidad.ProductoSucursal;
import com.microservicio.api.sucursal.dominio.modelo.Sucursal;
import org.springframework.stereotype.Component;

@Component
public class FabricaProductoSucursal {

    public ProductoSucursal crear(ComandoProducto comandoProducto, Long idProducto) {
        return new ProductoSucursal(
                new Producto(idProducto),
                new Sucursal(comandoProducto.getIdSucursal()),
                comandoProducto.getStock(),
                comandoProducto.getPrecioVenta()
        );
    }

}
