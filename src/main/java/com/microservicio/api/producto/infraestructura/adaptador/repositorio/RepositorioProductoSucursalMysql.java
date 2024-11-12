package com.microservicio.api.producto.infraestructura.adaptador.repositorio;

import com.microservicio.api.producto.dominio.modelo.entidad.ProductoActualizar;
import com.microservicio.api.producto.dominio.modelo.entidad.ProductoSucursal;
import com.microservicio.api.producto.dominio.puerto.repositorio.RepositorioProductoSucursal;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioProductoSucursalMysql implements RepositorioProductoSucursal {

    private final ProductoSucursalJpaRepository productoSucursalJpaRepository;

    public RepositorioProductoSucursalMysql(ProductoSucursalJpaRepository productoSucursalJpaRepository) {
        this.productoSucursalJpaRepository = productoSucursalJpaRepository;
    }

    @Override
    public void actualizarStock(ProductoActualizar productoActualizar) {
        this.productoSucursalJpaRepository.actualizarPorStock(productoActualizar.getIdSucursal(),
                productoActualizar.getId(), productoActualizar.getStock());
    }

    @Override
    public Long crear(ProductoSucursal producto) {
        this.productoSucursalJpaRepository.save(producto);
        return 1L;
    }

    @Override
    public void eliminar(Long id) {
        this.productoSucursalJpaRepository.eliminar(id);
    }

}
