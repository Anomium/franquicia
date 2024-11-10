package com.microservicio.api.franquicia.infraestructura;

import com.microservicio.api.franquicia.dominio.puerto.RepositorioFranquicia;
import com.microservicio.api.franquicia.dominio.servicio.ServicioActualizarFranquicia;
import com.microservicio.api.franquicia.dominio.servicio.ServicioCrearFranquicia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioFranquicia {

    @Bean
    public ServicioCrearFranquicia servicioCrearFranquicia(RepositorioFranquicia repositorioFranquicia) {
        return new ServicioCrearFranquicia(repositorioFranquicia);
    }

    @Bean
    public ServicioActualizarFranquicia servicioActualizarFranquicia(RepositorioFranquicia repositorioFranquicia) {
        return new ServicioActualizarFranquicia(repositorioFranquicia);
    }
}
