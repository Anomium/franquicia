package com.microservicio.api.franquicia.infraestructura.controlador;

import com.microservicio.api.comun.comun_aplicacion.ComandoRespuesta;
import com.microservicio.api.franquicia.aplicacion.comando.ComandoActualizarFranquicia;
import com.microservicio.api.franquicia.aplicacion.comando.ComandoFranquicia;
import com.microservicio.api.franquicia.aplicacion.comando.manejador.ManejadorActualizarFranquicia;
import com.microservicio.api.franquicia.aplicacion.comando.manejador.ManejadorCrearFranquicia;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/franquicias")
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

    @GetMapping
    public String saludo() {
        return "hola";
    }
}
