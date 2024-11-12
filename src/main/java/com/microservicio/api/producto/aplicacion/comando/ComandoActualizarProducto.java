package com.microservicio.api.producto.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoActualizarProducto {

    private Long id;
    private Long idSucursal;
    private String nombreNuevo;
    private Integer stock;

}
