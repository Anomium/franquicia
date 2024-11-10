package com.microservicio.api.sucursal.dominio.puerto;

import com.microservicio.api.sucursal.dominio.modelo.Sucursal;
import com.microservicio.api.sucursal.dominio.modelo.SucursalActualizar;

public interface RepositorioSucursal {

    Long crear(Sucursal sucursal);

    void actualizar(SucursalActualizar sucursalActualizar);

    void eliminar(Long id);

    boolean existe(String nombre);

    boolean existePorNombre(String nombre);

}
