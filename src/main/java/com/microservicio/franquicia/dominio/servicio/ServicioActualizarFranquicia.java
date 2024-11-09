package com.microservicio.franquicia.dominio.servicio;

import com.microservicio.comun.comun_dominio.excepcion.ExcepcionDuplicidad;
import com.microservicio.franquicia.dominio.modelo.FranquiciaActualizar;
import com.microservicio.franquicia.dominio.puerto.RepositorioFranquicia;

public class ServicioActualizarFranquicia {

    public static final String LA_FRANQUICIA_NO_EXISTE_EN_EL_SISTEMA = "La franquicia no existe en el sistema";
    private final RepositorioFranquicia repositorioFranquicia;

    public ServicioActualizarFranquicia(RepositorioFranquicia repositorioFranquicia) {
        this.repositorioFranquicia = repositorioFranquicia;
    }

    public void ejecutar(FranquiciaActualizar franquiciaActualizar) {
        validarExistenciaPrevia(franquiciaActualizar);
        this.repositorioFranquicia.actualizar(franquiciaActualizar);
    }

    private void validarExistenciaPrevia(FranquiciaActualizar franquiciaActualizar) {
        boolean existe = this.repositorioFranquicia.existePorNombre(franquiciaActualizar.getNombreActual());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_FRANQUICIA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
