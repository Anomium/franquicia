package com.microservicio.api.sucursal.aplicacion.comando.manejador;

import com.microservicio.api.comun.comun_aplicacion.ComandoRespuesta;
import com.microservicio.api.comun.comun_aplicacion.manejador.ManejadorComandoRespuesta;
import com.microservicio.api.sucursal.aplicacion.comando.ComandoSucursal;
import com.microservicio.api.sucursal.aplicacion.comando.fabrica.FabricaSucursal;
import com.microservicio.api.sucursal.dominio.modelo.Sucursal;
import com.microservicio.api.sucursal.dominio.servicio.ServicioCrearSucursal;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSucursal implements ManejadorComandoRespuesta<ComandoSucursal, ComandoRespuesta<Long>> {

    private final FabricaSucursal fabricaSucursal;
    private final ServicioCrearSucursal servicioCrearSucursal;

    public ManejadorCrearSucursal(FabricaSucursal fabricaSucursal,
                                  ServicioCrearSucursal servicioCrearSucursal) {
        this.fabricaSucursal = fabricaSucursal;
        this.servicioCrearSucursal = servicioCrearSucursal;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSucursal comando) {
        Sucursal sucursal = this.fabricaSucursal.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearSucursal.ejecutar(sucursal));
    }
}
