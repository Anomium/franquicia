package com.microservicio.api.producto.aplicacion.comando.manejador;

import com.microservicio.api.producto.dominio.modelo.dto.DtoProducto;
import com.microservicio.api.producto.dominio.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarProductosMayorStock {

    private final DaoProducto daoProducto;

    public ManejadorListarProductosMayorStock(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public List<DtoProducto> listar(String idFranquicia) {
        return this.daoProducto.listar(idFranquicia);
    }
}
