package com.microservicio.api.producto.dominio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoProducto {

    private Long id;
    private String nombreSucursal;
    private String nombreProducto;
    private Integer stock;

}
