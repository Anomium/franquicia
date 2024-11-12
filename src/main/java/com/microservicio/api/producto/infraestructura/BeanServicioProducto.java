package com.microservicio.api.producto.infraestructura;

import com.microservicio.api.producto.dominio.puerto.repositorio.RepositorioProducto;
import com.microservicio.api.producto.dominio.puerto.repositorio.RepositorioProductoSucursal;
import com.microservicio.api.producto.dominio.servicio.ServicioActualizarNombreProducto;
import com.microservicio.api.producto.dominio.servicio.ServicioActualizarStockProducto;
import com.microservicio.api.producto.dominio.servicio.ServicioCrearProducto;
import com.microservicio.api.producto.dominio.servicio.ServicioEliminarProducto;
import com.microservicio.api.producto.infraestructura.adaptador.repositorio.RepositorioProductoSucursalMysql;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioProducto {

    @Bean
    public ServicioCrearProducto servicioCrearProducto(RepositorioProducto repositorioProducto,
                                                       RepositorioProductoSucursal repositorioProductoSucursal) {
        return new ServicioCrearProducto(repositorioProducto, repositorioProductoSucursal);
    }

    @Bean
    public ServicioActualizarNombreProducto servicioActualizarNombreProducto(RepositorioProducto repositorioProducto) {
        return new ServicioActualizarNombreProducto(repositorioProducto);
    }

    @Bean
    public ServicioActualizarStockProducto servicioActualizarStockProducto(RepositorioProductoSucursalMysql repositorioProductoSucursalMysql) {
        return new ServicioActualizarStockProducto(repositorioProductoSucursalMysql);
    }

    @Bean
    public ServicioEliminarProducto servicioEliminarProducto(RepositorioProductoSucursal repositorioProductoSucursal) {
        return new ServicioEliminarProducto(repositorioProductoSucursal);
    }

}
