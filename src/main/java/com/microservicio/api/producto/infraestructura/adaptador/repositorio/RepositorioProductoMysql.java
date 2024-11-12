package com.microservicio.api.producto.infraestructura.adaptador.repositorio;

import com.microservicio.api.comun.comun_dominio.excepcion.ExcepcionDuplicidad;
import com.microservicio.api.producto.dominio.modelo.entidad.Producto;
import com.microservicio.api.producto.dominio.modelo.entidad.ProductoActualizar;
import com.microservicio.api.producto.dominio.puerto.repositorio.RepositorioProducto;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioProductoMysql implements RepositorioProducto {

    private final ProductoJpaRepository productoJpaRepository;

    public RepositorioProductoMysql(ProductoJpaRepository productoJpaRepository) {
        this.productoJpaRepository = productoJpaRepository;
    }

    @Override
    public Producto crear(Producto producto) {
        return this.productoJpaRepository.save(producto);
    }

    @Override
    public Producto buscarPorId(Long idProducto) {
        return productoJpaRepository.findById(idProducto)
                .orElseThrow(() -> new ExcepcionDuplicidad("Error"));
    }

    @Override
    public void actualizarNombre(ProductoActualizar productoActualizar) {
        this.productoJpaRepository.actualizarPorNombre(productoActualizar.getId(),
                productoActualizar.getNombreNuevo());
    }

    @Override
    public void eliminar(Long id) {
        //this.productoJpaRepository.eliminar(id);
    }

    @Override
    public boolean existe(String nombre) {
        return false;
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return this.productoJpaRepository.existsByNombre(nombre);
    }
}
