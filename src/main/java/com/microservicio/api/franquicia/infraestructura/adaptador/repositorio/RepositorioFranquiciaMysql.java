package com.microservicio.api.franquicia.infraestructura.adaptador.repositorio;

import com.microservicio.api.franquicia.dominio.modelo.Franquicia;
import com.microservicio.api.franquicia.dominio.modelo.FranquiciaActualizar;
import com.microservicio.api.franquicia.dominio.puerto.RepositorioFranquicia;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioFranquiciaMysql implements RepositorioFranquicia {

    private final FranquiciaJpaRepository franquiciaJpaRepository;

    public RepositorioFranquiciaMysql(FranquiciaJpaRepository franquiciaJpaRepository) {
        this.franquiciaJpaRepository = franquiciaJpaRepository;
    }

    @Override
    public Long crear(Franquicia franquicia) {
        this.franquiciaJpaRepository.save(franquicia);
        return 1L;
    }

    @Override
    public void actualizar(FranquiciaActualizar franquiciaActualizar) {
        this.franquiciaJpaRepository.actualizarPorNombre(franquiciaActualizar.getNombreActual(),
                franquiciaActualizar.getNombreNuevo());
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(String nombre) {
        return false;
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return this.franquiciaJpaRepository.existsByNombre(nombre);
    }
}
