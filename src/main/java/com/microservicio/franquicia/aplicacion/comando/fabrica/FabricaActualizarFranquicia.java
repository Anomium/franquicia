package com.microservicio.franquicia.aplicacion.comando.fabrica;

import com.microservicio.franquicia.aplicacion.comando.ComandoActualizarFranquicia;
import com.microservicio.franquicia.dominio.modelo.FranquiciaActualizar;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaActualizarFranquicia {

    public FranquiciaActualizar crear(ComandoActualizarFranquicia comandoActualizarFranquicia) {
        return new FranquiciaActualizar(
                comandoActualizarFranquicia.getNombreNuevo(),
                comandoActualizarFranquicia.getNombreActual()
        );
    }

}
