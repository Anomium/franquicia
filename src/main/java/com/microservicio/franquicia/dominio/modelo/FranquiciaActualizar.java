package com.microservicio.franquicia.dominio.modelo;

import lombok.Getter;

@Getter
public class FranquiciaActualizar {

    String nombreNuevo;
    String nombreActual;

    public FranquiciaActualizar(String nombreNuevo, String nombreActual) {
        this.nombreNuevo = nombreNuevo;
        this.nombreActual = nombreActual;
    }
}
