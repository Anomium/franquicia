package com.microservicio.franquicia.dominio.servicio;

import com.microservicio.comun.comun_dominio.excepcion.ExcepcionDuplicidad;
import com.microservicio.franquicia.dominio.modelo.Franquicia;
import com.microservicio.franquicia.dominio.puerto.RepositorioFranquicia;

public class ServicioCrearFranquicia {

    public static final String LA_FRANQUICIA_YA_EXISTE_EN_EL_SISTEMA = "La franquicia ya existe en el sistema";

    private final RepositorioFranquicia repositorioFranquicia;

    public ServicioCrearFranquicia(RepositorioFranquicia repositorioFranquicia) {
        this.repositorioFranquicia = repositorioFranquicia;
    }

    public Long ejecutar(Franquicia franquicia) {
        validarExistenciaPrevia(franquicia);
        return this.repositorioFranquicia.crear(franquicia);
    }

    private void validarExistenciaPrevia(Franquicia franquicia) {
        boolean existe = this.repositorioFranquicia.existe(franquicia.getNombre());
        if (existe) {
            throw new ExcepcionDuplicidad(LA_FRANQUICIA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
