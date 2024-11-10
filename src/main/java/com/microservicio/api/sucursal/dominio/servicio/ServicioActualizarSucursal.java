package com.microservicio.api.sucursal.dominio.servicio;

import com.microservicio.api.comun.comun_dominio.excepcion.ExcepcionDuplicidad;
import com.microservicio.api.sucursal.dominio.puerto.RepositorioSucursal;
import com.microservicio.api.sucursal.dominio.modelo.SucursalActualizar;

public class ServicioActualizarSucursal {

    public static final String LA_FRANQUICIA_NO_EXISTE_EN_EL_SISTEMA = "La franquicia no existe en el sistema";
    private final RepositorioSucursal repositorioSucursal;

    public ServicioActualizarSucursal(RepositorioSucursal repositorioSucursal) {
        this.repositorioSucursal = repositorioSucursal;
    }

    public void ejecutar(SucursalActualizar sucursalActualizar) {
        validarExistenciaPrevia(sucursalActualizar);
        this.repositorioSucursal.actualizar(sucursalActualizar);
    }

    private void validarExistenciaPrevia(SucursalActualizar sucursalActualizar) {
        boolean existe = this.repositorioSucursal.existePorNombre(sucursalActualizar.getNombreActual());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_FRANQUICIA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
