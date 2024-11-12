package com.microservicio.api.producto.dominio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DtoProducto {

    private String nombreProducto;
    private String nombreSucursal;
    private Integer stock;
    private BigDecimal precioVenta;

}
