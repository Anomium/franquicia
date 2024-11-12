package com.microservicio.api.producto.dominio.puerto.dao;

import com.microservicio.api.producto.dominio.modelo.dto.DtoProducto;

import java.util.List;

public interface DaoProducto {

    List<DtoProducto> listar(String idFranquicia);

}
