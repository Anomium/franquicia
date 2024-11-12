package com.microservicio.api.producto.infraestructura.adaptador.dao;

import com.microservicio.api.producto.dominio.modelo.dto.DtoProducto;
import com.microservicio.api.producto.dominio.puerto.dao.DaoProducto;
import com.microservicio.api.producto.infraestructura.adaptador.repositorio.ProductoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoProductoMysql implements DaoProducto {

    private final ProductoJpaRepository productoJpaRepository;

    public DaoProductoMysql(ProductoJpaRepository productoJpaRepository) {
        this.productoJpaRepository = productoJpaRepository;
    }

    @Override
    public List<DtoProducto> listar(String idFranquicia) {
        return this.productoJpaRepository.listarProductoMayorStockPorSucursal(idFranquicia);
    }
}
