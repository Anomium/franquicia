package com.microservicio.api.sucursal.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSucursal {

    private Long idfranquicia;

    private String nombre;

    private String direccion;

    private String telefono;

}
