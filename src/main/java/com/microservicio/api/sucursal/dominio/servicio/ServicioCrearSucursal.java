package com.microservicio.api.sucursal.dominio.servicio;

import com.microservicio.api.comun.comun_dominio.excepcion.ExcepcionDuplicidad;
import com.microservicio.api.sucursal.dominio.modelo.Sucursal;
import com.microservicio.api.sucursal.dominio.puerto.RepositorioSucursal;

public class ServicioCrearSucursal {

    public static final String LA_SUCURSAL_YA_EXISTE_EN_EL_SISTEMA = "La sucursal ya existe en el sistema";

    private final RepositorioSucursal repositorioSucursal;

    public ServicioCrearSucursal(RepositorioSucursal repositorioSucursal) {
        this.repositorioSucursal = repositorioSucursal;
    }

    public Long ejecutar(Sucursal sucursal) {
        return this.repositorioSucursal.crear(sucursal);
    }

}
