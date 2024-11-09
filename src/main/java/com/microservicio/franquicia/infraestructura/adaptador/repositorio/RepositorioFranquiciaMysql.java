package com.microservicio.franquicia.infraestructura.adaptador.repositorio;

import com.microservicio.franquicia.dominio.modelo.Franquicia;
import com.microservicio.franquicia.dominio.puerto.RepositorioFranquicia;
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
    public void actualizar(Franquicia franquicia) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(String nombre) {
        return false;
    }

    @Override
    public boolean existePorId(Long id) {
        return false;
    }
}
