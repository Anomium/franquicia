package com.microservicio.api.sucursal.infraestructura.controlador;

import com.microservicio.api.comun.comun_aplicacion.ComandoRespuesta;
import com.microservicio.api.sucursal.aplicacion.comando.ComandoActualizarSucursal;
import com.microservicio.api.sucursal.aplicacion.comando.ComandoSucursal;
import com.microservicio.api.sucursal.aplicacion.comando.manejador.ManejadorActualizarSucursal;
import com.microservicio.api.sucursal.aplicacion.comando.manejador.ManejadorCrearSucursal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sucursal")
public class ComandoControladorSucursal {

    private final ManejadorCrearSucursal manejadorCrearSucursal;
    private final ManejadorActualizarSucursal manejadorActualizarSucursal;

    public ComandoControladorSucursal(ManejadorCrearSucursal manejadorCrearSucursal,
                                      ManejadorActualizarSucursal manejadorActualizarSucursal) {
        this.manejadorCrearSucursal = manejadorCrearSucursal;
        this.manejadorActualizarSucursal = manejadorActualizarSucursal;
    }

    @PostMapping("/create")
    public ComandoRespuesta<Long> create(@RequestBody ComandoSucursal comandoSucursal) {
        return manejadorCrearSucursal.ejecutar(comandoSucursal);
    }

    @PutMapping
    public void update(@RequestBody ComandoActualizarSucursal comandoActualizarSucursal) {
        manejadorActualizarSucursal.ejecutar(comandoActualizarSucursal);
    }

}
