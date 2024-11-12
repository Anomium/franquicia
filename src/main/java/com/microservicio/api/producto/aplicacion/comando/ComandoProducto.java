package com.microservicio.api.producto.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoProducto {

    private Long idSucursal;
    private String nombre;
    private String descripcion;
    private BigDecimal precioBase;
    private Integer stock;
    private BigDecimal precioVenta;

}
