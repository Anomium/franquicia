package com.microservicio.franquicia.infraestructura;

import com.microservicio.franquicia.dominio.puerto.RepositorioFranquicia;
import com.microservicio.franquicia.dominio.servicio.ServicioCrearFranquicia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearFranquicia servicioCrearFranquicia(RepositorioFranquicia repositorioFranquicia) {
        return new ServicioCrearFranquicia(repositorioFranquicia);
    }

}
