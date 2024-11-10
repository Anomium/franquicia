package com.microservicio.api.sucursal.dominio.modelo;

import com.microservicio.api.franquicia.dominio.modelo.Franquicia;
import com.microservicio.api.franquicia.dominio.modelo.ProductoSucursal;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_franquicia", nullable = false)
    private Franquicia franquicia;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String direccion;

    @Column(length = 20)
    private String telefono;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @ElementCollection
    @CollectionTable(
            name = "producto_sucursal",
            joinColumns = @JoinColumn(name = "sucursal_id")
    )
    @Column(name = "producto_id")
    private List<ProductoSucursal> productosSucursal;

    public Sucursal(Franquicia franquicia, String direccion, String nombre, String telefono) {
        this.franquicia = franquicia;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

}
