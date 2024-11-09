package com.microservicio.franquicia.aplicacion.comando.manejador;

import com.microservicio.comun.comun_aplicacion.ComandoRespuesta;
import com.microservicio.comun.comun_aplicacion.manejador.ManejadorComandoRespuesta;
import com.microservicio.franquicia.aplicacion.comando.ComandoFranquicia;
import com.microservicio.franquicia.aplicacion.comando.fabrica.FabricaFranquicia;
import com.microservicio.franquicia.dominio.modelo.Franquicia;
import com.microservicio.franquicia.dominio.servicio.ServicioCrearFranquicia;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearFranquicia implements ManejadorComandoRespuesta<ComandoFranquicia, ComandoRespuesta<Long>> {

    private final FabricaFranquicia fabricaFranquicia;
    private final ServicioCrearFranquicia servicioCrearFranquicia;

    public ManejadorCrearFranquicia(FabricaFranquicia fabricaFranquicia, ServicioCrearFranquicia servicioCrearFranquicia) {
        this.fabricaFranquicia = fabricaFranquicia;
        this.servicioCrearFranquicia = servicioCrearFranquicia;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoFranquicia comando) {
        Franquicia franquicia = this.fabricaFranquicia.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearFranquicia.ejecutar(franquicia));
    }
}
