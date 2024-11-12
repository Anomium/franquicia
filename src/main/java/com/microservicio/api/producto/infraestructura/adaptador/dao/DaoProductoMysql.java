package com.microservicio.api.producto.infraestructura.adaptador.dao;

import com.microservicio.api.producto.dominio.modelo.dto.DtoProducto;
import com.microservicio.api.producto.dominio.puerto.dao.DaoProducto;
import com.microservicio.api.producto.infraestructura.adaptador.repositorio.ProductoJpaRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DaoProductoMysql implements DaoProducto {

    private final ProductoJpaRepository productoJpaRepository;

    public DaoProductoMysql(ProductoJpaRepository productoJpaRepository) {
        this.productoJpaRepository = productoJpaRepository;
    }

    @Override
    public List<DtoProducto> listar(String idFranquicia) {
        List<Object[]> objects = this.productoJpaRepository.listarProductoMayorStockPorSucursal(idFranquicia);
        List<DtoProducto> dtos = new ArrayList<>();
        for (Object[] fila : objects) {
            DtoProducto dto = new DtoProducto();
            dto.setNombreProducto(fila[0].toString());
            dto.setNombreSucursal(fila[1].toString());
            dto.setStock((Integer) fila[2]);
            dto.setPrecioVenta((BigDecimal) fila[3]);
            dtos.add(dto);
        }
        return dtos;
    }
}
