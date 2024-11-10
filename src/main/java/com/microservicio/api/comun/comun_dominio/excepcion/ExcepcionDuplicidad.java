package com.microservicio.api.comun.comun_dominio.excepcion;

public class ExcepcionDuplicidad extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionDuplicidad(String mensaje) {
        super(mensaje);
    }

}
