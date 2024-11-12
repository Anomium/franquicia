package com.microservicio.api.producto.dominio.servicio;

import com.microservicio.api.comun.comun_dominio.excepcion.ExcepcionDuplicidad;
import com.microservicio.api.producto.dominio.modelo.entidad.ProductoActualizar;
import com.microservicio.api.producto.dominio.puerto.repositorio.RepositorioProducto;

public class ServicioActualizarNombreProducto {

    public static final String LA_PRODUCTO_NO_EXISTE_EN_EL_SISTEMA = "El producto no existe en el sistema";
    private final RepositorioProducto repositorioProducto;

    public ServicioActualizarNombreProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(ProductoActualizar productoActualizar) {
        validarExistenciaPrevia(productoActualizar);
        this.repositorioProducto.actualizarNombre(productoActualizar);
    }

    private void validarExistenciaPrevia(ProductoActualizar productoActualizar) {
        boolean existe = this.repositorioProducto.existePorNombre(productoActualizar.getNombreNuevo());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_PRODUCTO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
