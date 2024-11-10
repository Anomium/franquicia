package com.microservicio.api.sucursal.dominio.modelo;

import lombok.Getter;

@Getter
public class SucursalActualizar {

    String nombreNuevo;
    String nombreActual;

    public SucursalActualizar(String nombreNuevo, String nombreActual) {
        this.nombreNuevo = nombreNuevo;
        this.nombreActual = nombreActual;
    }
}
