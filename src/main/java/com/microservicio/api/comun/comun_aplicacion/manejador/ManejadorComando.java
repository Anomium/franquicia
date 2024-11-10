package com.microservicio.api.comun.comun_aplicacion.manejador;


import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComando<C> {

    @Transactional
    void ejecutar(C comando);

}
