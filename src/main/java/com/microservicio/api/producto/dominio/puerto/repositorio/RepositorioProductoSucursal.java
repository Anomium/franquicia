package com.microservicio.api.producto.dominio.puerto.repositorio;

import com.microservicio.api.producto.dominio.modelo.entidad.ProductoActualizar;
import com.microservicio.api.producto.dominio.modelo.entidad.ProductoSucursal;

public interface RepositorioProductoSucursal {

    void actualizarStock(ProductoActualizar productoActualizar);
    Long crear(ProductoSucursal producto);
    void eliminar(Long id);

}
