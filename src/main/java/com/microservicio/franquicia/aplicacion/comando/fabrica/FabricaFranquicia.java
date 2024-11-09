package com.microservicio.franquicia.aplicacion.comando.fabrica;

import com.microservicio.franquicia.aplicacion.comando.ComandoFranquicia;
import com.microservicio.franquicia.dominio.modelo.Franquicia;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaFranquicia {

    public Franquicia crear(ComandoFranquicia comandoFranquicia) {
        return new Franquicia(
                comandoFranquicia.getNombre(),
                LocalDateTime.now()
        );
    }

}
