package com.microservicio.api.franquicia.aplicacion.comando.fabrica;

import com.microservicio.api.franquicia.aplicacion.comando.ComandoActualizarFranquicia;
import com.microservicio.api.franquicia.dominio.modelo.FranquiciaActualizar;
import org.springframework.stereotype.Component;

@Component
public class FabricaActualizarFranquicia {

    public FranquiciaActualizar crear(ComandoActualizarFranquicia comandoActualizarFranquicia) {
        return new FranquiciaActualizar(
                comandoActualizarFranquicia.getNombreNuevo(),
                comandoActualizarFranquicia.getNombreActual()
        );
    }

}
