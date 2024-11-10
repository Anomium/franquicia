package com.microservicio.api.sucursal.aplicacion.comando.fabrica;

import com.microservicio.api.franquicia.dominio.modelo.Franquicia;
import com.microservicio.api.sucursal.aplicacion.comando.ComandoSucursal;
import com.microservicio.api.sucursal.dominio.modelo.Sucursal;
import org.springframework.stereotype.Component;

@Component
public class FabricaSucursal {

    public Sucursal crear(ComandoSucursal comandoSucursal) {
        return new Sucursal(
            new Franquicia(comandoSucursal.getIdfranquicia()),
                comandoSucursal.getDireccion(),
                comandoSucursal.getNombre(),
                comandoSucursal.getTelefono()
        );
    }

}
