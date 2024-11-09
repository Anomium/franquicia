package com.microservicio.franquicia.dominio.puerto;

import com.microservicio.franquicia.dominio.modelo.Franquicia;

public interface RepositorioFranquicia {

    Long crear(Franquicia franquicia);

    void actualizar(Franquicia franquicia);

    void eliminar(Long id);

    boolean existe(String nombre);

    boolean existePorId(Long id);

}
