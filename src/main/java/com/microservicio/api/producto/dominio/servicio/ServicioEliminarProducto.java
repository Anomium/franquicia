package com.microservicio.api.producto.dominio.servicio;

import com.microservicio.api.producto.dominio.puerto.repositorio.RepositorioProductoSucursal;

public class ServicioEliminarProducto {

    private final RepositorioProductoSucursal repositorioProductoSucursal;


    public ServicioEliminarProducto(RepositorioProductoSucursal repositorioProductoSucursal) {
        this.repositorioProductoSucursal = repositorioProductoSucursal;
    }

    public void ejecutar(Long idProducto) {
        this.repositorioProductoSucursal.eliminar(idProducto);
    }
}
