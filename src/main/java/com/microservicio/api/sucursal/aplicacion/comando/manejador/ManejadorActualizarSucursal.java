package com.microservicio.api.sucursal.aplicacion.comando.manejador;

import com.microservicio.api.comun.comun_aplicacion.manejador.ManejadorComando;
import com.microservicio.api.sucursal.aplicacion.comando.ComandoActualizarSucursal;
import com.microservicio.api.sucursal.aplicacion.comando.fabrica.FabricaActualizarSucursal;
import com.microservicio.api.sucursal.dominio.modelo.SucursalActualizar;
import com.microservicio.api.sucursal.dominio.servicio.ServicioActualizarSucursal;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarSucursal implements ManejadorComando<ComandoActualizarSucursal> {

    private final FabricaActualizarSucursal fabricaActualizarSucursal;
    private final ServicioActualizarSucursal servicioActualizarSucursal;

    public ManejadorActualizarSucursal(FabricaActualizarSucursal fabricaActualizarSucursal,
                                       ServicioActualizarSucursal servicioActualizarSucursal) {
        this.fabricaActualizarSucursal = fabricaActualizarSucursal;
        this.servicioActualizarSucursal = servicioActualizarSucursal;
    }

    @Override
    public void ejecutar(ComandoActualizarSucursal comandoActualizarSucursal) {
        SucursalActualizar sucursalActualizar = fabricaActualizarSucursal.crear(comandoActualizarSucursal);
        this.servicioActualizarSucursal.ejecutar(sucursalActualizar);
    }

}
