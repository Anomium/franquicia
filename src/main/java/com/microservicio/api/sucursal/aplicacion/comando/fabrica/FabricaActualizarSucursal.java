package com.microservicio.api.sucursal.aplicacion.comando.fabrica;

import com.microservicio.api.sucursal.aplicacion.comando.ComandoActualizarSucursal;
import com.microservicio.api.sucursal.dominio.modelo.SucursalActualizar;
import org.springframework.stereotype.Component;

@Component
public class FabricaActualizarSucursal {

    public SucursalActualizar crear(ComandoActualizarSucursal comandoActualizarSucursal) {
        return new SucursalActualizar(
                comandoActualizarSucursal.getNombreNuevo(),
                comandoActualizarSucursal.getNombreActual()
        );
    }

}
