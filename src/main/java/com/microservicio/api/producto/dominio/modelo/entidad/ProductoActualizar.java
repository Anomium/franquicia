package com.microservicio.api.producto.dominio.modelo.entidad;

import lombok.Getter;

@Getter
public class ProductoActualizar {

    private Long id;
    private Long idSucursal;
    private String nombreNuevo;
    private Integer stock;

    public ProductoActualizar(Long id, String nombreNuevo) {
        this.id = id;
        this.nombreNuevo = nombreNuevo;
    }

    public ProductoActualizar(Long idSucursal, Long id, Integer stock) {
        this.idSucursal = idSucursal;
        this.id = id;
        this.stock = stock;
    }
}
