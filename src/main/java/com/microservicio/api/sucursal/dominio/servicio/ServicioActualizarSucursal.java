package com.microservicio.api.sucursal.dominio.servicio;

import com.microservicio.api.sucursal.dominio.modelo.SucursalActualizar;
import com.microservicio.api.sucursal.dominio.puerto.RepositorioSucursal;

public class ServicioActualizarSucursal {

    private final RepositorioSucursal repositorioSucursal;

    public ServicioActualizarSucursal(RepositorioSucursal repositorioSucursal) {
        this.repositorioSucursal = repositorioSucursal;
    }

    public void ejecutar(SucursalActualizar sucursalActualizar) {
        this.repositorioSucursal.actualizar(sucursalActualizar);
    }

}
