package com.microservicio.api.franquicia.infraestructura.adaptador.repositorio;

import com.microservicio.api.franquicia.dominio.modelo.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaJpaRepository extends JpaRepository<Franquicia, Long> {

    boolean existsByNombre(String nombre);

    @Modifying
    @Query(value = "UPDATE franquicia f SET f.nombre = :nuevoNombre WHERE LOWER(f.nombre) = LOWER(:nombreActual)", nativeQuery = true)
    void actualizarPorNombre(@Param("nombreActual") String nombreActual,
                            @Param("nuevoNombre") String nuevoNombre);
}
