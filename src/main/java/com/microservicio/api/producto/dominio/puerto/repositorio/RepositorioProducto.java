package com.microservicio.api.producto.dominio.puerto.repositorio;

import com.microservicio.api.producto.dominio.modelo.entidad.Producto;
import com.microservicio.api.producto.dominio.modelo.entidad.ProductoActualizar;

public interface RepositorioProducto {

    Producto crear(Producto producto);

    Producto buscarPorId(Long idProducto);

    void actualizarNombre(ProductoActualizar productoActualizar);

    void eliminar(Long id);

    boolean existe(String nombre);

    boolean existePorNombre(String nombre);

}
