package com.microservicio.api.producto.dominio.servicio;

import com.microservicio.api.comun.comun_dominio.excepcion.ExcepcionDuplicidad;
import com.microservicio.api.producto.dominio.modelo.entidad.Producto;
import com.microservicio.api.producto.dominio.modelo.entidad.ProductoSucursal;
import com.microservicio.api.producto.dominio.puerto.repositorio.RepositorioProducto;
import com.microservicio.api.producto.dominio.puerto.repositorio.RepositorioProductoSucursal;

public class ServicioCrearProducto {

    public static final String LA_FRANQUICIA_YA_EXISTE_EN_EL_SISTEMA = "La franquicia ya existe en el sistema";

    private final RepositorioProducto repositorioProducto;
    private final RepositorioProductoSucursal repositorioProductoSucursal;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto,
                                 RepositorioProductoSucursal repositorioProductoSucursal) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioProductoSucursal = repositorioProductoSucursal;
    }

    public Long ejecutar(Producto producto) {
        validarExistenciaPrevia(producto);
        Long id = this.repositorioProducto.crear(producto).getIdProducto();
        return id;
    }

    public Long ejecutar(ProductoSucursal productoSucursal) {
        this.repositorioProductoSucursal.crear(productoSucursal);
        return 1L;
    }

    private void validarExistenciaPrevia(Producto producto) {
        boolean existe = this.repositorioProducto.existe(producto.getNombre());
        if (existe) {
            throw new ExcepcionDuplicidad(LA_FRANQUICIA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
