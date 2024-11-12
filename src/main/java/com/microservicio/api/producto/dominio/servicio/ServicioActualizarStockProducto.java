package com.microservicio.api.producto.dominio.servicio;

//import com.microservicio.api.comun.comun_dominio.excepcion.ExcepcionDuplicidad;
import com.microservicio.api.producto.dominio.modelo.entidad.ProductoActualizar;
import com.microservicio.api.producto.infraestructura.adaptador.repositorio.RepositorioProductoSucursalMysql;

public class ServicioActualizarStockProducto {

    public static final String LA_PRODUCTO_NO_EXISTE_EN_EL_SISTEMA = "El producto no existe en el sistema";

    private final RepositorioProductoSucursalMysql repositorioProductoSucursalMysql;

    public ServicioActualizarStockProducto(RepositorioProductoSucursalMysql repositorioProductoSucursalMysql) {
        this.repositorioProductoSucursalMysql = repositorioProductoSucursalMysql;
    }

    public void ejecutar(ProductoActualizar productoActualizar) {
//        validarExistenciaPrevia(productoActualizar);
        this.repositorioProductoSucursalMysql.actualizarStock(productoActualizar);
    }

/*    private void validarExistenciaPrevia(ProductoActualizar productoActualizar) {
        boolean existe = this.repositorioProductoSucursalMysql.existePorNombre(productoActualizar.getNombreActual());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_PRODUCTO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }*/
}
