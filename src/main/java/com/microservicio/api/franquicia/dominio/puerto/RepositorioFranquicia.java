package com.microservicio.api.franquicia.dominio.puerto;

import com.microservicio.api.franquicia.dominio.modelo.Franquicia;
import com.microservicio.api.franquicia.dominio.modelo.FranquiciaActualizar;

public interface RepositorioFranquicia {

    Long crear(Franquicia franquicia);

    void actualizar(FranquiciaActualizar franquiciaActualizar);

    void eliminar(Long id);

    boolean existe(String nombre);

    boolean existePorNombre(String nombre);

}
