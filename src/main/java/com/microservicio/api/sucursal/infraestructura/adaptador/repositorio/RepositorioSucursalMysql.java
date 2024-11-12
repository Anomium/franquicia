package com.microservicio.api.sucursal.infraestructura.adaptador.repositorio;

import com.microservicio.api.sucursal.dominio.modelo.Sucursal;
import com.microservicio.api.sucursal.dominio.puerto.RepositorioSucursal;
import com.microservicio.api.sucursal.dominio.modelo.SucursalActualizar;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSucursalMysql implements RepositorioSucursal {

    private final SucursalJpaRepository sucursalJpaRepository;

    public RepositorioSucursalMysql(SucursalJpaRepository sucursalJpaRepository) {
        this.sucursalJpaRepository = sucursalJpaRepository;
    }

    @Override
    public Long crear(Sucursal sucursal) {
        this.sucursalJpaRepository.save(sucursal);
        return 1L;
    }

    @Override
    public void actualizar(SucursalActualizar sucursalActualizar) {
        this.sucursalJpaRepository.actualizarPorNombre(sucursalActualizar.getNombreActual(),
                sucursalActualizar.getNombreNuevo());
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(String nombre) {
        return false;
    }

}
