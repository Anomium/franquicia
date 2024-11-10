package com.microservicio.api.sucursal;

import com.microservicio.api.sucursal.dominio.puerto.RepositorioSucursal;
import com.microservicio.api.sucursal.dominio.servicio.ServicioActualizarSucursal;
import com.microservicio.api.sucursal.dominio.servicio.ServicioCrearSucursal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioSucursal {

    @Bean
    public ServicioCrearSucursal servicioCrearSucursal(RepositorioSucursal repositorioSucursal) {
        return new ServicioCrearSucursal(repositorioSucursal);
    }

    @Bean
    public ServicioActualizarSucursal servicioActualizarSucursal(RepositorioSucursal repositorioSucursal) {
        return new ServicioActualizarSucursal(repositorioSucursal);
    }
}
