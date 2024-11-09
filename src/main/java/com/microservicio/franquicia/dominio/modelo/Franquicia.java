package com.microservicio.franquicia.dominio.modelo;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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

    @OneToMany(mappedBy = "franquicia", cascade = CascadeType.ALL)
    private List<Sucursal> sucursales;

    public Franquicia(String nombre, LocalDateTime fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }
}
