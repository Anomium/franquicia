package com.microservicio.api.franquicia.dominio.modelo;


import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "franquicia")
public class Franquicia {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFranquicia;

    @Column(nullable = false, length = 100)
    private String nombre;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;


    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @ElementCollection
    @CollectionTable(
            name = "franquicia_sucursales",
            joinColumns = @JoinColumn(name = "franquicia_id")
    )
    @Column(name = "sucursal_id")
    private List<Long> sucursalIds = new ArrayList<>();

    public Franquicia(String nombre, LocalDateTime fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }

    public Franquicia(Long idFranquicia) {
        this.idFranquicia = idFranquicia;
    }
}
