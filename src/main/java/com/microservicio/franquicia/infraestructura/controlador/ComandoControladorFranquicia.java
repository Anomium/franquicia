package com.microservicio.franquicia.infraestructura.controlador;

import com.microservicio.comun.comun_aplicacion.ComandoRespuesta;
import com.microservicio.franquicia.aplicacion.comando.ComandoActualizarFranquicia;
import com.microservicio.franquicia.aplicacion.comando.ComandoFranquicia;
import com.microservicio.franquicia.aplicacion.comando.manejador.ManejadorActualizarFranquicia;
import com.microservicio.franquicia.aplicacion.comando.manejador.ManejadorCrearFranquicia;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/franquicias")
public class ComandoControladorFranquicia {

    private final ManejadorCrearFranquicia manejadorCrearFranquicia;
    private final ManejadorActualizarFranquicia manejadorActualizarFranquicia;

    public ComandoControladorFranquicia(ManejadorCrearFranquicia manejadorCrearFranquicia, ManejadorActualizarFranquicia manejadorActualizarFranquicia) {
        this.manejadorCrearFranquicia = manejadorCrearFranquicia;
        this.manejadorActualizarFranquicia = manejadorActualizarFranquicia;
    }

    @PostMapping
    public ComandoRespuesta<Long> create(@RequestBody ComandoFranquicia comandoFranquicia) {
        return manejadorCrearFranquicia.ejecutar(comandoFranquicia);
    }

    @PutMapping
    public void update(@RequestBody ComandoActualizarFranquicia comandoActualizarFranquicia) {
        manejadorActualizarFranquicia.ejecutar(comandoActualizarFranquicia);
    }
}
