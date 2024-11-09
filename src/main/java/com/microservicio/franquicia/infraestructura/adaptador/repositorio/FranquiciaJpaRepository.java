package com.microservicio.franquicia.infraestructura.adaptador.repositorio;

import com.microservicio.franquicia.dominio.modelo.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaJpaRepository extends JpaRepository<Franquicia, Long> {



}
