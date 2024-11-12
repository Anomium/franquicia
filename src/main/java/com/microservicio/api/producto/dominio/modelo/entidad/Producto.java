package com.microservicio.api.producto.dominio.modelo.entidad;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "precio_base", precision = 10, scale = 2)
    private BigDecimal precioBase;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<ProductoSucursal> productosSucursal;

    public Producto(String nombre, String descripcion, BigDecimal precioBase) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
    }

    public Producto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public void idProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Long idProducto, String nombre, String descripcion, BigDecimal precioBase, LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion, List<ProductoSucursal> productosSucursal) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.productosSucursal = productosSucursal;
    }
}
