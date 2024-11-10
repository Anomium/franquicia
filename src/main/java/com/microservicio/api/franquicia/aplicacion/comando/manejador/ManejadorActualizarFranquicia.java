package com.microservicio.api.franquicia.aplicacion.comando.manejador;

import com.microservicio.api.comun.comun_aplicacion.manejador.ManejadorComando;
import com.microservicio.api.franquicia.aplicacion.comando.ComandoActualizarFranquicia;
import com.microservicio.api.franquicia.aplicacion.comando.fabrica.FabricaActualizarFranquicia;
import com.microservicio.api.franquicia.dominio.modelo.FranquiciaActualizar;
import com.microservicio.api.franquicia.dominio.servicio.ServicioActualizarFranquicia;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarFranquicia implements ManejadorComando<ComandoActualizarFranquicia> {

    private final FabricaActualizarFranquicia fabricaActualizarFranquicia;
    private final ServicioActualizarFranquicia servicioActualizarFranquicia;

    public ManejadorActualizarFranquicia(FabricaActualizarFranquicia fabricaActualizarFranquicia,
                                         ServicioActualizarFranquicia servicioActualizarFranquicia) {
        this.fabricaActualizarFranquicia = fabricaActualizarFranquicia;
        this.servicioActualizarFranquicia = servicioActualizarFranquicia;
    }

    @Override
    public void ejecutar(ComandoActualizarFranquicia comandoActualizarFranquicia) {
        FranquiciaActualizar franquiciaActualizar = fabricaActualizarFranquicia.crear(comandoActualizarFranquicia);
        this.servicioActualizarFranquicia.ejecutar(franquiciaActualizar);
    }

}
