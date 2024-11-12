package com.microservicio.api.sucursal.infraestructura.adaptador.repositorio;

import com.microservicio.api.sucursal.dominio.modelo.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalJpaRepository extends JpaRepository<Sucursal, Long> {

    @Modifying
    @Query(value = "UPDATE sucursal s SET s.nombre = :nuevoNombre WHERE LOWER(s.nombre) = LOWER(:nombreActual)", nativeQuery = true)
    void actualizarPorNombre(@Param("nombreActual") String nombreActual,
                            @Param("nuevoNombre") String nuevoNombre);
}
